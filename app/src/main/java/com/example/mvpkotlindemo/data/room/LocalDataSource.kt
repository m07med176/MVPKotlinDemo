package com.example.mvpkotlindemo.data.room

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvpkotlindemo.data.model.Product

class LocalDataSource(context:Context):LocalInteface {
    val favoriteDao:FavoriteDao by lazy {
        AppDatabase.getInstance(context).getFavorite()
    }

    override suspend fun getAllProudects(): LiveData<List<Product>> {
        return favoriteDao.getAllProudects()
    }

    override suspend fun insertProudect(proudect: Product): Long {
        return favoriteDao.insertProudect(proudect)
    }

    override suspend fun deleteProudect(proudect: Product): Int {
        return favoriteDao.deleteProudect(proudect)
    }
}