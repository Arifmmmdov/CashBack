package com.example.cashback.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    fun getInstance(): ApiInterface{
//        var client = OkHttpClient.Builder().addInterceptor()
        var retrofitBuilder = Retrofit.Builder()
            .baseUrl("baseUrl")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitBuilder.create(ApiInterface::class.java)
    }
}