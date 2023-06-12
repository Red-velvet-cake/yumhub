package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.local.entities.CategoryDatabaseDto

fun CategoryDatabaseDto.toCategoryRecipeEntity(): CategoryEntity {
    return CategoryEntity(
        imageResource = imageResource,
        title = title
    )
}