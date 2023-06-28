package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.utils.orEmpty

fun List<QuickAnswerEntity>.toMapper(): List<ChatBotResultUIState> {
    return this.flatMap { chatBotResult ->
        listOfNotNull(
            chatBotResult.qsn.takeIf { it.isNotEmpty() }?.let { ChatBotResultUIState(true, it, "") },
            chatBotResult.answer.takeIf { it.isNotEmpty() }?.let { ChatBotResultUIState(false, it, chatBotResult.image) }
        )
    }
}