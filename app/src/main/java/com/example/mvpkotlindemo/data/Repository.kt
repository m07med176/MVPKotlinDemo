package com.example.mvpkotlindemo.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvpkotlindemo.data.model.Product
import com.example.mvpkotlindemo.data.network.NetworkCallBack
import com.example.mvpkotlindemo.data.network.RemoteDataSource
import com.example.mvpkotlindemo.data.room.LocalDataSource

class Repository private constructor(context: Context):RepositoryInteface {
    val localDataSource =  LocalDataSource(context)
    val remoteDataSource = RemoteDataSource()

    companion object{
        private var instant:RepositoryInteface?=null

        fun getInstance(context: Context):RepositoryInteface{
            return instant?: synchronized(this){
                instant?: Repository(context).also { instant = it }
            }
        }
    }
    override fun getProudects(networkCallBack: NetworkCallBack) {
        return remoteDataSource.getProudects(networkCallBack)
    }

    override suspend fun getAllProudects(): LiveData<List<Product>> {
        return localDataSource.getAllProudects()
    }

    override suspend fun insertProudect(proudect: Product): Long {
        return localDataSource.insertProudect(proudect)
    }

    override suspend fun deleteProudect(proudect: Product): Int {
        return localDataSource.deleteProudect(proudect)
    }
}