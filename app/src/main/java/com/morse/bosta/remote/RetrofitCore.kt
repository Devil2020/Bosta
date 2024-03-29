package com.morse.bosta.remote

import com.morse.bosta.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitCore {

    private val interceptors = arrayListOf(HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }, if (BuildConfig.isTest) MockInterceptor() else Interceptor { chain ->
        val request = chain.request().newBuilder()
        chain.proceed(request.build())
    })

    private fun getCore(baseUrl: String) = Retrofit.Builder()
        .client(OkHttpClient.Builder().apply {
            interceptors.forEach {
                addInterceptor(it)
            }
            writeTimeout(1, TimeUnit.MINUTES)
            readTimeout(1, TimeUnit.MINUTES)
            connectTimeout(1, TimeUnit.MINUTES)
        }.build())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    fun getGatewayAgent(baseUrl: String = BuildConfig.BASE_URL) =
        getCore(baseUrl).create(Api::class.java)
}