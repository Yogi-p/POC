package com.example.virginmoney.network

import com.example.virginmoney.models.User
import com.example.virginmoney.models.UserDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface UserApi {

    companion object {
        private const val PARAM_USER_ID = "movieId"
        private const val USER_DETAILS = "movie_0{$PARAM_USER_ID}.json"
        const val COLLEAGUES = "people"
        const val ROOMS = "rooms"
    }

    @GET(EndPoints.BASE_URL + COLLEAGUES)
    fun getUsers(): Call<List<User>>
    @GET(EndPoints.BASE_URL + USER_DETAILS)
    fun getUserDetails(@Path(PARAM_USER_ID) movieId: Int): Call<UserDetails>
}