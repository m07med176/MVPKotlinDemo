package com.example.mvpkotlindemo.features.productsFavortie.presenter

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.mvpkotlindemo.data.model.Product

interface FavoritePresenterInterface {
    fun getAllProudects(lifecycleObserver: LifecycleOwner)
    suspend fun deleteProudect (proudect: Product)
}