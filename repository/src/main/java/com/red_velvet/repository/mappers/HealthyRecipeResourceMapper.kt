package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import com.red_velvet.repository.utils.orZero

internal fun RecipeInformationResource.toHealthyRecipeEntity(): HealthyRecipeEntity {
    return HealthyRecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
    )
}