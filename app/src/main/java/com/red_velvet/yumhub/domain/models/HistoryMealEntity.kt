package com.red_velvet.yumhub.domain.models

import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.HistoryItemLocalDto

data class HistoryMealEntity(
    val id: Int, val title: String, val image: String, val description: String, var viewedAt: Long
)


fun HistoryItemLocalDto.toHistoryItemLocalEntity(): HistoryMealEntity {
    return HistoryMealEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
        description = description.orEmpty(),
        viewedAt = viewedAt.orZero()
    )
}