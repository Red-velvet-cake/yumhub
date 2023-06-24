package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryItemLocalDto(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String,
    val description: String
)
