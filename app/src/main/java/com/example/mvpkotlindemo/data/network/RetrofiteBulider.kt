package com.example.mvpkotlindemo.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofiteBulider{
    const val BASE_URL = "https://dummyjson.com/"
    val retrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
