package com.example.cashback.retrofit

import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET(/* Get url of api server*/)
    suspend fun getUsers(): Response<ResponseModel>

}