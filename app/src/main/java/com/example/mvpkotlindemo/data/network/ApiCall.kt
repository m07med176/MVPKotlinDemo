package com.example.mvpkotlindemo.data.network

import com.example.mvpkotlindemo.data.model.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiCall {
    @GET("products")
    fun getProudects(): Call<ProductsResponse>
}