package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FAVORITE_RECIPES_TABLE")
data class FavoriteRecipeDto(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    val image: String,
    val overview: String
)