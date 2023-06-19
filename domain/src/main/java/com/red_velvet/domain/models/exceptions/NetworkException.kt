package com.red_velvet.domain.models.exceptions

sealed class NetworkException : Exception() {

    object UnAuthorizedException :NetworkException()

    object NoInternetException : NetworkException()

    object TimeoutException : NetworkException()

    object NotFoundException :NetworkException()

    object ApiKeyExpiredException : NetworkException()

}
