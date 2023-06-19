package com.red_velvet.ui.base

sealed class ErrorUIState() {

    object UnAuthorized : ErrorUIState()

    object NoInternet : ErrorUIState()

    object ConnectionTimeout : ErrorUIState()

    object InternalServerError : ErrorUIState()

}