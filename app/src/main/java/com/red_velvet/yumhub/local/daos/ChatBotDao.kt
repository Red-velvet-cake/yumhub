package com.red_velvet.yumhub.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.red_velvet.yumhub.local.entities.QuickAnswerLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatBotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChatBotMessage(quickAnswerLocalDto: QuickAnswerLocalDto)

    @Query("SELECT * FROM QUICK_ANSWER_TABLE")
    fun getChatBotMessages(): Flow<List<QuickAnswerLocalDto>>
}