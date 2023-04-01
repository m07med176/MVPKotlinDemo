package com.example.mvpkotlindemo.data.room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvpkotlindemo.data.model.Product

interface LocalInteface {

    suspend fun getAllProudects(): LiveData<List<Product>>

    suspend fun insertProudect (proudect: Product): Long

    suspend fun deleteProudect (proudect: Product): Int
}