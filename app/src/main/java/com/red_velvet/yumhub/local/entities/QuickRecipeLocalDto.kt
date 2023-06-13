package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class QuickRecipeLocalDto(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String,
    val cookingMinutes: Int
)
