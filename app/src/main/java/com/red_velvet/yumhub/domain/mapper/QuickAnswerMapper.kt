package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import com.red_velvet.yumhub.domain.utils.orEmpty

fun QuickAnswerDto.toModel(): QuickAnswer {
    return QuickAnswer(
        answer = this.answer.orEmpty(),
        image = this.image.orEmpty(),
        type = this.type.orEmpty()
    )
}