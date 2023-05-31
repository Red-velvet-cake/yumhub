package com.red_velvet.yumhub.data.remote

import com.red_velvet.yumhub.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {

    private val apiKey = BuildConfig.API_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .url(buildUrl(request))
            .build()
        return chain.proceed(newRequest)
    }

    private fun buildUrl(request: Request): HttpUrl {
        return request.url.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .build()
    }

    companion object {
        const val API_KEY = "api_key"
    }
}