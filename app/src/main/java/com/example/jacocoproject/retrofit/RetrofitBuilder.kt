package com.example.jacocoproject.retrofit

import com.example.jacocoproject.api.HelpApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://restcountries-v1.p.rapidapi.com"
    private val interceptor by lazy { HttpLoggingInterceptor() }

    fun create(): HelpApi {
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(HelpApi::class.java)
    }
}