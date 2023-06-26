package com.red_velvet.yumhub.domain.models

import com.red_velvet.yumhub.local.entities.SliderItemLocalDto

data class SliderItemEntity(
    val imageResource: Int
)

fun List<SliderItemLocalDto>.toEntity(): List<SliderItemEntity> {
    return this.map {
        SliderItemEntity(
            imageResource = it.imageResource
        )
    }
}