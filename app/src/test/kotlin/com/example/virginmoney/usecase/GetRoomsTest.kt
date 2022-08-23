package com.example.virginmoney.usecase

import com.example.virginmoney.UnitTest
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.network.UseCase
import com.example.virginmoney.repository.UserRepositoryInterfaceImpl
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRoomsTest : UnitTest() {

    private lateinit var getRooms: GetRooms

    @MockK
    private lateinit var userRepository: UserRepositoryInterfaceImpl

    @Before
    fun setUp() {
        getRooms = GetRooms(userRepository)
        every { userRepository.getRooms() } returns BaseResponse.Success(listOf(Rooms.empty))
    }

    @Test
    fun `Receive data from repository`() {
        runBlocking { getRooms.run(UseCase.None()) }
        verify(exactly = 1) { userRepository.getRooms() }
    }
}