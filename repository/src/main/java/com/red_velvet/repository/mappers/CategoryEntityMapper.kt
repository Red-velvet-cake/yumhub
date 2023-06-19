package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.CategoryEntity
import com.red_velvet.repository.entities.CategoryDatabaseDto

internal fun CategoryEntity.toCategoryRecipeDto(): CategoryDatabaseDto {
    return CategoryDatabaseDto(
        imageResource = imageResource,
        title = title
    )
}