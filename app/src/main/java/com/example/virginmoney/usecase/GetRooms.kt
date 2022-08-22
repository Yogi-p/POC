package com.example.virginmoney.usecase

import com.example.virginmoney.models.Rooms
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.repository.UserRepositoryInterface
import javax.inject.Inject

class GetRooms @Inject constructor(private val userRepository: UserRepositoryInterface) : UseCase<List<Rooms>, UseCase.None>() {

    override suspend fun run(params: None) = userRepository.getRooms()
}