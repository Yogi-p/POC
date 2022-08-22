package com.example.virginmoney.repository

import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.models.User

interface UserRepositoryInterface {
    fun getUsers() : BaseResponse<Failure, List<User>>
    fun getRooms(): BaseResponse<Failure, List<Rooms>>
}