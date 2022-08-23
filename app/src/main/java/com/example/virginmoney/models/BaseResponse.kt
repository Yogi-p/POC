package com.example.virginmoney.models

sealed class BaseResponse<out L, out R> {
    
    /** * Represents the left side of [BaseResponse] class which by convention is a "Failure". */
    data class Failed<out L>(val a: L) : BaseResponse<L, Nothing>()

    /** * Represents the right side of [BaseResponse] class which by convention is a "Success". */
    data class Success<out R>(val b: R) : BaseResponse<Nothing, R>()


    /**
     * Applies fnL if this is a Failed or fnR if this is a Success.
     * @see Failed
     * @see Success
     */
    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Failed -> fnL(a)
            is Success -> fnR(b)
        }

    /**
     * Returns true if this is a Success, false otherwise.
     * @see Success
     */
    val isSuccess get() = this is Success<R>

    /**
     * Returns true if this is a Failed, false otherwise.
     * @see Success
     */
    val isFailed get() = this is Failed<L>

}




