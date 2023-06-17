package com.red_velvet.yumhub.remote

import com.red_velvet.yumhub.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor() : Interceptor {

    private val apiKey = BuildConfig.API_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = buildUrl(request.url)
        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }

    private fun buildUrl(url: HttpUrl): HttpUrl {
        return url.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .build()
    }

    companion object {
        const val API_KEY = "apiKey"
    }
}
