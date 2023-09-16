package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealPlanLocalDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val position: Int,
    val slot: Int,
    val type: String,
    val timestamp: Long
)