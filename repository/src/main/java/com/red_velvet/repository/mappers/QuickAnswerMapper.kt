package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.repository.resources.recipe.QuickAnswerResource

internal fun QuickAnswerResource.toEntity(): QuickAnswerEntity {
    return QuickAnswerEntity(
        answer = this.answer.orEmpty(),
        image = this.image.orEmpty(),
        type = this.type.orEmpty()
    )
}