package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.utils.orEmpty

fun com.red_velvet.yumhub.remote.dtos.recipe.QuickAnswerDto.toModel(): QuickAnswerEntity {
    return QuickAnswerEntity(
        answer = this.answer.orEmpty(),
        image = this.image.orEmpty(),
        type = this.type.orEmpty()
    )
}