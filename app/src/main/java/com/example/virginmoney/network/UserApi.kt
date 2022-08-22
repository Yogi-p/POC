package com.example.virginmoney.network

import com.example.virginmoney.models.Rooms
import com.example.virginmoney.models.User
import retrofit2.Call
import retrofit2.http.GET

internal interface UserApi {

    companion object {
        const val COLLEAGUES = "people"
        const val ROOMS = "rooms"
    }

    @GET(EndPoints.BASE_URL + COLLEAGUES)
    fun getUsers(): Call<List<User>>
    @GET(EndPoints.BASE_URL + ROOMS)
    fun getRooms(): Call<List<Rooms>>
}