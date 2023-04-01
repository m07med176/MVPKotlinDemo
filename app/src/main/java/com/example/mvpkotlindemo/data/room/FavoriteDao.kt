package com.example.mvpkotlindemo.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvpkotlindemo.data.model.Product




@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Proudects_Tabel")
    fun getAllProudects(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProudect (proudect: Product): Long

    @Delete
    suspend fun deleteProudect (proudect: Product): Int

}