package com.red_velvet.yumhub.data.repositories.mappers

import com.red_velvet.yumhub.data.local.entities.CategoryDatabaseDto
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity

fun CategoryDatabaseDto.toCategoryRecipeEntity(): CategoryEntity {
    return CategoryEntity(
        imageResource = imageResource,
        title = title
    )
}