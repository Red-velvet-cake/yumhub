package com.red_velvet.yumhub.domain.models

import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.local.entities.HistoryItemLocalDto

data class HistoryMealEntity(
    val id: Int, val title: String, val image: String, val description: String
)

fun HistoryMealEntity.toHistoryItemLocalDto(): HistoryItemLocalDto {
    return HistoryItemLocalDto(
        id = id, title = title, image = image, description = description,
    )
}

fun HistoryItemLocalDto.toHistoryItemLocalEntity(): HistoryMealEntity {
    return HistoryMealEntity(
        id = id.orZero(), title = title.orEmpty(), image = image.orEmpty(), description = description.orEmpty(),
    )
}