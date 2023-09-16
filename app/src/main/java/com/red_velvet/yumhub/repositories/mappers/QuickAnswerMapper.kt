package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.remote.resources.recipe.QuickAnswerResource

fun QuickAnswerResource.toEntity(): QuickAnswerEntity {
    return QuickAnswerEntity(
        answer = this.answer.orEmpty(),
        image = this.image.orEmpty(),
        qsn = ""
    )
}