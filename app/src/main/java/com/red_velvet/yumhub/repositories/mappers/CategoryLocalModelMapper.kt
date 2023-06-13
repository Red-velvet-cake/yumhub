package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.local.entities.CategoryLocalDto

fun CategoryLocalDto.toEntity(): CategoryEntity {
    return CategoryEntity(
        imageResource = imageResource,
        title = title
    )
}