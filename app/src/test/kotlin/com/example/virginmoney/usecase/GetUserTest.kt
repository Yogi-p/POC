package com.example.virginmoney.usecase

import com.example.virginmoney.UnitTest
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.User
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.repository.UserRepositoryInterfaceImpl
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUserTest : UnitTest() {

    private lateinit var getUsers: GetUsers

    @MockK
    private lateinit var userRepository: UserRepositoryInterfaceImpl

    @Before
    fun setUp() {
        getUsers = GetUsers(userRepository)
        every { userRepository.getUsers() } returns BaseResponse.Success(listOf(User.empty))
    }

    @Test
    fun `Receive data from repository`() {
        runBlocking { getUsers.run(UseCase.None()) }

        verify(exactly = 1) { userRepository.getUsers() }
    }
}