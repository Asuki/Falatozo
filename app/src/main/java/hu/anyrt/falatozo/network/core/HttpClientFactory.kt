package hu.anyrt.falatozo.network.core

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class HttpClientFactory {
    fun getClient() : OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }
}