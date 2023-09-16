package com.red_velvet.yumhub.remote

import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor(
    private val sharedPreferenceService: SharedPreferenceService
) : Interceptor {

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
            .addQueryParameter(API_KEY, sharedPreferenceService.getApiKey())
            .build()
    }

    companion object {
        const val API_KEY = "apiKey"
    }
}
