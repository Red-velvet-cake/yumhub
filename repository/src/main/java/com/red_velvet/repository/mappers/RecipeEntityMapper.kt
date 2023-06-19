package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.RecipeEntity
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import com.red_velvet.repository.utils.orZero

internal fun RecipeInformationResource.toRecipeEntity(): RecipeEntity {
    return RecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = image.orEmpty()
    )
}