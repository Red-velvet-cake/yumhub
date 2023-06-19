package com.red_velvet.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class HealthyRecipeLocalDto(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String
)
