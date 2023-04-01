package com.example.mvpkotlindemo.features.productsFavortie.view

import com.example.mvpkotlindemo.data.model.Product

interface FavoriteViewInterface {

    fun favoriteDataCallBack(products:List<Product>)
}