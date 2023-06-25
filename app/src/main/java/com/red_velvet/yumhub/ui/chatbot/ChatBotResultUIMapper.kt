package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.utils.orEmpty

fun List<QuickAnswerEntity>.toMapper(): List<ChatBotResultUIState>{
    return this.map {
        ChatBotResultUIState(
            qsn = it.qsn.orEmpty(),
            image = it.image.orEmpty(),
            answer = it.answer.orEmpty(),
        )
    }
}