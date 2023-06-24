package com.red_velvet.yumhub.local.entities

import androidx.room.Entity

@Entity(tableName = "HISTORY_ITEM")
data class HistoryItemLocalDto(
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val date: String
)
