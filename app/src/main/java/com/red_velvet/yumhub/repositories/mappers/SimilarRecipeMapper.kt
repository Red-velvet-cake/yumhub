package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource

fun RecipeInformationResource.toSimilarRecipeEntity(): SimilarRecipeEntity {
    return SimilarRecipeEntity(
        id = this.id.orZero(),
        imageType = this.imageType.orEmpty(),
        readyInMinutes = this.readyInMinutes.orZero(),
        servings = this.servings.orZero(),
        sourceUrl = this.sourceUrl.orEmpty(),
        title = this.title.orEmpty()
    )
}