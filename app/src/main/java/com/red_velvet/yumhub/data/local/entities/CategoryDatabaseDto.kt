package com.red_velvet.yumhub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORIES_TABLE")
data class CategoryDatabaseDto(
    val imageResource: Int,
    @PrimaryKey
    val title: String
)
