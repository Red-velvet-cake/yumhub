package com.red_velvet.repository.mappers

import com.red_velvet.domain.models.recipes.SimilarRecipeEntity
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import com.red_velvet.repository.utils.orZero

internal fun RecipeInformationResource.toSimilarRecipeEntity(): SimilarRecipeEntity {
    return SimilarRecipeEntity(
        id = this.id.orZero(),
        imageType = this.imageType.orEmpty(),
        readyInMinutes = this.readyInMinutes.orZero(),
        servings = this.servings.orZero(),
        sourceUrl = this.sourceUrl.orEmpty(),
        title = this.title.orEmpty()
    )
}