package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.domain.models.HistoryMealEntity
import com.red_velvet.yumhub.local.entities.HistoryItemLocalDto

fun HistoryMealEntity.toHistoryItemLocalDto(): HistoryItemLocalDto {
    return HistoryItemLocalDto(
        id = id, title = title, image = image, description = description,
    )
}