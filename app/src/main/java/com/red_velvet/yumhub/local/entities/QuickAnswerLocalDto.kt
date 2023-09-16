package com.red_velvet.yumhub.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QUICK_ANSWER_TABLE")
data class QuickAnswerLocalDto(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val qsn: String?,
    val answer: String?,
    val image: String?
)
