package com.example.mvpkotlindemo.features.productsList.presenter

import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.data.network.NetworkCallBack

interface ProductsListInterface {

    fun getProudects()

    suspend fun insertProudect (proudect: Product)

}