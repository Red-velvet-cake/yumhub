package com.red_velvet.repository.mappers

import com.red_velvet.repository.entities.CategoryLocalDto


internal fun CategoryLocalDto.toCategoryEntity(): com.red_velvet.domain.models.recipes.CategoryEntity {
    return com.red_velvet.domain.models.recipes.CategoryEntity(
        imageResource = imageResource,
        title = title
    )
}