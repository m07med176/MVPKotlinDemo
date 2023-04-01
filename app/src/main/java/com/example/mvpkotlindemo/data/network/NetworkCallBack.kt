package com.example.mvpkotlindemo.data.network

import com.example.mvpkotlindemo.data.model.Product


interface NetworkCallBack {
    fun onSuccessResult(products:List<Product>)
    fun onFailureResult(message:String)
}