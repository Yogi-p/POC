package com.example.virginmoney.repository

import com.example.virginmoney.base.NetworkHandler
import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.User
import com.example.virginmoney.models.UserDetails
import com.example.virginmoney.network.UserService
import retrofit2.Call
import javax.inject.Inject

class UserRepositoryInterfaceImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: UserService) : UserRepositoryInterface {

    override fun getUsers(): BaseResponse<Failure, List<User>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.getUsers(),
                { it.map {
                    User(it.id, it.createdAt, it.firstName, it.avatar, it.lastName, it.email,
                        it.jobtitle,it.favouriteColor)
                } },
                emptyList()
            )
            false -> BaseResponse.Failed(Failure.NetworkConnection)
        }
    }

    override fun getUserDetailsDetails(movieId: Int): BaseResponse<Failure, UserDetails> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.getUserDetails(movieId),
                {
//                    it.toMovieDetails()
                UserDetails()
                },
                UserDetails()
            )
            false -> BaseResponse.Failed(Failure.NetworkConnection)
        }
    }

    private fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): BaseResponse<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> BaseResponse.Success(transform((response.body() ?: default)))
                false -> BaseResponse.Failed(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            BaseResponse.Failed(Failure.ServerError)
        }
    }
}
