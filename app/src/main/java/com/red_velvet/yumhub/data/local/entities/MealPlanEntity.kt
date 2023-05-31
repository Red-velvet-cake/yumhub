package com.red_velvet.yumhub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealPlanEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val position: Int,
        val slot: Int,
        val type: String,
        val imageType: String,
        val servings: Int,
        val title: String,
        val timestamp: Long
)