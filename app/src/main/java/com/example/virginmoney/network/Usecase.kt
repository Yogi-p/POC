package com.example.virginmoney.network

import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.BaseResponse
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): BaseResponse<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (BaseResponse<Failure, Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}
