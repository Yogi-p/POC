package com.example.virginmoney.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(retrofit: Retrofit) : UserApi {
    private val usersApi by lazy { retrofit.create(UserApi::class.java) }

    override fun getUsers() = usersApi.getUsers()
    override fun getUserDetails(movieId: Int) = usersApi.getUserDetails(movieId)

}
