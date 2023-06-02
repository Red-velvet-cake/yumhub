package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer

fun QuickAnswerDto.toModel(): QuickAnswer {
    return QuickAnswer(
        answer = this.answer ?: "",
        image = this.image ?: "",
        type = this.type ?: ""
    )
}