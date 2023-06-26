package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.utils.orEmpty

fun List<QuickAnswerEntity>.toMapper(): List<ChatBotResultUIState> {
    val result: MutableList<ChatBotResultUIState> = mutableListOf()
    for (chatBotResult in this) {
        if (chatBotResult.qsn.isNotEmpty()) {
            val questionTest = ChatBotResultUIState(true, chatBotResult.qsn, "")
            result.add(questionTest)
        }

        if (chatBotResult.answer.isNotEmpty()) {
            val answerTest = ChatBotResultUIState(false, chatBotResult.answer, chatBotResult.image)
            result.add(answerTest)
        }
    }

    return result
}