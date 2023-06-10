package com.red_velvet.yumhub.domain.models.exceptions

sealed class NetworkExceptionEntity : Exception() {

    object UnAuthorizedExceptionEntity : NetworkExceptionEntity()

    object NoInternetExceptionEntity : NetworkExceptionEntity()

    object TimeoutExceptionEntity : NetworkExceptionEntity()

    object NotFoundExceptionEntity : NetworkExceptionEntity()

}
