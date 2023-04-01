package com.example.mvpkotlindemo.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "Proudects_Tabel")
data class Product(
    var brand: String?=null,
    var category: String?=null,
    var description: String?=null,
    var discountPercentage: Double?=null,
    @PrimaryKey
    var id: Int?=null,
    @Ignore
    var images: List<String>?=null,
    var price: Int?=null,
    var rating: Double?=null,
    var stock: Int?=null,
    var thumbnail: String?=null,
    var title: String?=null
)