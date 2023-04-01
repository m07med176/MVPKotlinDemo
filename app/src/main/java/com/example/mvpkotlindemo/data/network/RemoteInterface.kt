package com.example.mvpkotlindemo.data.network

import com.example.mvpkotlindemo.data.model.ProductsResponse
import retrofit2.Call

interface RemoteInterface {
    fun getProudects(networkCallBack: NetworkCallBack)
}