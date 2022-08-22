package com.example.virginmoney.exception

/**
 * Base Class for handling errors/failures/exceptions.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object ListNotAvailable : Failure()
}
