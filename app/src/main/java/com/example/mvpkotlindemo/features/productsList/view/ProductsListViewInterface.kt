package com.example.mvpkotlindemo.features.productsList.view

import com.example.mvpkotlindemo.data.model.Product

interface ProductsListViewInterface {
    fun remoteSuccessDataCallBack(products:List<Product>)
    fun remoteErrorDataCallBack(message:String)
}