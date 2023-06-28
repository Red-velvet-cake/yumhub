package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HISTORY_ITEM")
data class HistoryItemLocalDto(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val viewedAt: Long
)
