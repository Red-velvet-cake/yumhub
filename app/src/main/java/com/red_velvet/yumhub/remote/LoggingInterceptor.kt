package com.red_velvet.yumhub.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingInterceptor @Inject constructor() : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        println("Request URL: ${request.url}")

        request.body?.let { requestBody ->
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            println("Request Body: ${buffer.readUtf8()}")
        }

        val response = chain.proceed(request)

        println("Response Code: ${response.code}")

        response.body?.let { responseBody ->
            val responseBodyString = responseBody.string()
            println("Response Body: $responseBodyString")
            response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString)).build()
        }

        return response
    }
}
