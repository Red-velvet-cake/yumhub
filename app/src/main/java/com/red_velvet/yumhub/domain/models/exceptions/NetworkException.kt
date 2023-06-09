package com.red_velvet.yumhub.domain.models.exceptions

sealed class NetworkException : Exception() {

    object UnAuthorizedException : NetworkException()

    object NoInternetException : NetworkException()

    object TimeoutException : NetworkException()

    object NotFoundException : NetworkException()

}
