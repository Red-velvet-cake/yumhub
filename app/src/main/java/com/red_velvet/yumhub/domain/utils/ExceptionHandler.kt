package com.red_velvet.yumhub.domain.utils

import com.google.gson.Gson
import com.red_velvet.yumhub.data.remote.dtos.ApiResponse
import okhttp3.ResponseBody
import javax.inject.Inject

class ExceptionHandler @Inject constructor() {

    fun getException(
        statusCode: Int,
        errorBody: ResponseBody?
    ): Exception {
        val errorMessage = getErrorMessage(errorBody)
        return when (statusCode) {
            401 -> UnAuthorizedException(errorMessage)
            404 -> NotFoundException(errorMessage)
            408 -> TimeOutException(errorMessage)
            500 -> ServerException(errorMessage)
            else -> Exception(errorMessage)
        }
    }

    private fun getErrorMessage(errorBody: ResponseBody?): String {
        return parseErrorBody(errorBody).message.orEmpty()
    }

    private fun parseErrorBody(errorBody: ResponseBody?): ApiResponse {
        return try {
            Gson().fromJson(errorBody.toString(), ApiResponse::class.java)
        } catch (e: Exception) {
            throw e
        }
    }
}

class UnAuthorizedException(message: String) : Exception(message)

class ServerException(message: String) : Exception(message)

class TimeOutException(message: String) : Exception(message)

class NotFoundException(message: String) : Exception(message)