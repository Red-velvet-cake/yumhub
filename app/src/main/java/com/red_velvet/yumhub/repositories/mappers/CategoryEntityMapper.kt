package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.local.entities.CategoryDatabaseDto

fun CategoryEntity.toCategoryRecipeDto(): CategoryDatabaseDto {
    return CategoryDatabaseDto(
        imageResource = imageResource,
        title = title
    )
}