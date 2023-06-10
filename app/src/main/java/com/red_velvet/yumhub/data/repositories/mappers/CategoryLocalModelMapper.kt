package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.CategoryLocalModel
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity

fun CategoryLocalModel.toEntity(): CategoryEntity {
    return CategoryEntity(
        imageResource = imageResource,
        title = title
    )
}