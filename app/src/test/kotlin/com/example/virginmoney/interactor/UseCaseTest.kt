package com.example.virginmoney.interactor

import com.example.virginmoney.AndroidTest
import com.example.virginmoney.models.BaseResponse
import com.example.virginmoney.network.UseCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class UseCaseTest : AndroidTest() {

    private val useCase = MockUseCase()

    @Test
    fun `Executing use case should return 'BaseResponse' of use case type`() {
        val params = MockParams(TYPE_PARAM)
        val result = runBlocking { useCase.run(params) }
        result shouldBeEqualTo BaseResponse.Success(MockType(TYPE_TEST))
    }

    data class MockType(val name: String)
    data class MockParams(val name: String)

    private inner class MockUseCase : UseCase<MockType, MockParams>() {
        override suspend fun run(params: MockParams) = BaseResponse.Success(MockType(TYPE_TEST))
    }

    companion object {
        private const val TYPE_TEST = "Test"
        private const val TYPE_PARAM = "ParamTest"
    }
}
