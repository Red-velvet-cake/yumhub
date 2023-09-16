package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.local.entities.QuickAnswerLocalDto

fun List<QuickAnswerLocalDto>.toEntity(): List<QuickAnswerEntity> {
    return this.map {
        QuickAnswerEntity(

            qsn = it.qsn.orEmpty(),
            answer = it.answer.orEmpty(),
            image = it.image.orEmpty()
        )
    }
}