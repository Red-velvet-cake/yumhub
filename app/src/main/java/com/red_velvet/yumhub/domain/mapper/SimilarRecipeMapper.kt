package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDtoItem
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe

fun SimilarRecipesDtoItem.toModel(): SimilarRecipe {
    return SimilarRecipe(
        id = this.id ?: 0,
        imageType = this.imageType ?: "",
        readyInMinutes = this.readyInMinutes ?: 0,
        servings = this.servings ?: 0,
        sourceUrl = this.sourceUrl ?: "",
        title = this.title ?: ""
    )
}