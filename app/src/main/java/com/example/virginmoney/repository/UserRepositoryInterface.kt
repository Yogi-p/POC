package com.example.virginmoney.repository

import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.User
import com.example.virginmoney.models.UserDetails

interface UserRepositoryInterface {
    fun getUsers() : BaseResponse<Failure, List<User>>
    fun getUserDetailsDetails(movieId: Int): BaseResponse<Failure, UserDetails>
}