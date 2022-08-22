package com.example.virginmoney.usecase

import com.example.virginmoney.models.User
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.repository.UserRepositoryInterface
import com.example.virginmoney.repository.UserRepositoryInterfaceImpl
import javax.inject.Inject

class GetUsers @Inject constructor(private val userRepository: UserRepositoryInterface) : UseCase<List<User>, UseCase.None>() {

    override suspend fun run(params: None) = userRepository.getUsers()
}