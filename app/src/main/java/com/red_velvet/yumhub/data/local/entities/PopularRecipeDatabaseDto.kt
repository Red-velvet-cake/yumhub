package com.red_velvet.yumhub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PopularRecipeDatabaseDto(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String
)
