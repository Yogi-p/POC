package com.example.virginmoney.repository

import com.example.virginmoney.UnitTest
import com.example.virginmoney.base.NetworkHandler
import com.example.virginmoney.exception.Failure
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.models.User
import com.example.virginmoney.network.UserService
import io.mockk.Called
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class UserRepositoryInterfaceImplTest : UnitTest() {

    private lateinit var userRepository: UserRepositoryInterfaceImpl

    @MockK
    private lateinit var networkHandler: NetworkHandler

    @MockK
    private lateinit var service: UserService

    @MockK
    private lateinit var usersCall: Call<List<User>>

    @MockK
    private lateinit var userResponse: Response<List<User>>

    @MockK
    private lateinit var roomsCall: Call<List<Rooms>>

    @MockK
    private lateinit var roomResponse: Response<List<Rooms>>

    private val user : User = User("Dummy text","Dummy text","Dummy text","Dummy text","Dummy text",
        "Dummy text","Dummy text","Dummy text")

    private val room : Rooms = Rooms("Dummy text","Dummy text", true,10)

    @Before
    fun setUp() {
        userRepository = UserRepositoryInterfaceImpl(networkHandler, service)
    }

    @Test
    fun `API should return empty list by default`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { userResponse.body() } returns null
        every { userResponse.isSuccessful } returns true
        every { usersCall.execute() } returns userResponse
        every { service.getUsers() } returns usersCall

        val users = userRepository.getUsers()

        users shouldBeEqualTo BaseResponse.Success(emptyList<User>())
        verify(exactly = 1) { service.getUsers() }
    }

    @Test
    fun `API should get user list from service`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { userResponse.body() } returns listOf(user)
        every { userResponse.isSuccessful } returns true
        every { usersCall.execute() } returns userResponse
        every { service.getUsers() } returns usersCall

        val users = userRepository.getUsers()

        users shouldBeEqualTo BaseResponse.Success(listOf(user))
        verify(exactly = 1) { service.getUsers() }
    }

    @Test
    fun `API user service should return network failure when no connection`() {
        every { networkHandler.isNetworkAvailable() } returns false

        val users = userRepository.getUsers()

        users shouldBeInstanceOf BaseResponse::class.java
        users.isFailed shouldBeEqualTo true
        users.fold({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verify { service wasNot Called }
    }

    @Test
    fun `API user service should return server error if no successful response`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { userResponse.isSuccessful } returns false
        every { usersCall.execute() } returns userResponse
        every { service.getUsers() } returns usersCall

        val users = userRepository.getUsers()

        users shouldBeInstanceOf BaseResponse::class.java
        users.isFailed shouldBeEqualTo true
        users.fold({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }

    @Test
    fun `API getUser request should catch exceptions`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { usersCall.execute() } returns userResponse
        every { service.getUsers() } returns usersCall

        val users = userRepository.getUsers()

        users shouldBeInstanceOf BaseResponse::class.java
        users.isFailed shouldBeEqualTo true
        users.fold({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }

    @Test
    fun `API getRooms return empty rooms list by default`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { roomResponse.body() } returns null
        every { roomResponse.isSuccessful } returns true
        every { roomsCall.execute() } returns roomResponse
        every { service.getRooms() } returns roomsCall

        val rooms = userRepository.getRooms()

        rooms shouldBeEqualTo BaseResponse.Success(emptyList<Rooms>())
        verify(exactly = 1) { service.getRooms() }
    }

    @Test
    fun `API getRoom should get rooms list from service`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { roomResponse.body() } returns listOf(room)
        every { roomResponse.isSuccessful } returns true
        every { roomsCall.execute() } returns roomResponse
        every { service.getRooms() } returns roomsCall

        val rooms = userRepository.getRooms()

        rooms shouldBeEqualTo BaseResponse.Success(listOf(room))
        verify(exactly = 1) { service.getRooms() }
    }

    @Test
    fun `API getRoom service should return network failure when no connection`() {
        every { networkHandler.isNetworkAvailable() } returns false

        val rooms = userRepository.getRooms()

        rooms shouldBeInstanceOf BaseResponse::class.java
        rooms.isFailed shouldBeEqualTo true
        rooms.fold(
            { failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java },
            {})
        verify { service wasNot Called }
    }

    @Test
    fun `API getRoom service should return server error if no successful response`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { roomResponse.body() } returns null
        every { roomResponse.isSuccessful } returns false
        every { roomsCall.execute() } returns roomResponse
        every { service.getRooms() } returns roomsCall

        val rooms = userRepository.getRooms()

        rooms shouldBeInstanceOf BaseResponse::class.java
        rooms.isFailed shouldBeEqualTo true
        rooms.fold({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }

    @Test
    fun `API getRoom details request should catch exceptions`() {
        every { networkHandler.isNetworkAvailable() } returns true
        every { roomsCall.execute() } returns roomResponse
        every { service.getRooms() } returns roomsCall

        val rooms = userRepository.getRooms()

        rooms shouldBeInstanceOf BaseResponse::class.java
        rooms.isFailed shouldBeEqualTo true
        rooms.fold({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }
}