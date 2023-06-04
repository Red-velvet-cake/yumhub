package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDtoItem
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero

fun SimilarRecipesDtoItem.toModel(): SimilarRecipe {
    return SimilarRecipe(
        id = this.id.orZero(),
        imageType = this.imageType.orEmpty(),
        readyInMinutes = this.readyInMinutes.orZero(),
        servings = this.servings.orZero(),
        sourceUrl = this.sourceUrl.orEmpty(),
        title = this.title.orEmpty()
    )
}