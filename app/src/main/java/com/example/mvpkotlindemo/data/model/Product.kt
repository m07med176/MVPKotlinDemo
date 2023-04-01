package com.example.mvpkotlindemo.data.model

import androidx.room.Entity
import androidx.room.Ignore


@Entity(tableName = "Proudects_Tabel")
data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    @Ignore
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)