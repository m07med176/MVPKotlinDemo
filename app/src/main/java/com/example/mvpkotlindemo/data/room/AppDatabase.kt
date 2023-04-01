package com.example.mvpkotlindemo.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvpkotlindemo.data.model.Product



@Database (entities = arrayOf(Product::class), version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getFavorite(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance (context: Context):AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"product_database")
                    .build()
                INSTANCE = instance
                //return Instance
                instance
            }
        }
    }
}