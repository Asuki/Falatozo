package hu.anyrt.falatozo.network.core

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    fun makeHttpClient(httpClient: OkHttpClient, baseUrl: String): Retrofit {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
            .build()

        return  Retrofit.Builder()
            .client(httpClient)
            .baseUrl((baseUrl))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}