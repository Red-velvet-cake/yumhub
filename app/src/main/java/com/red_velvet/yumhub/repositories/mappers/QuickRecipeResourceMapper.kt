package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationDto

fun RecipeInformationDto.toQuickRecipeEntity(): QuickRecipeEntity {
    return QuickRecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
        cookingMinutes = cookingMinutes.orZero()
    )
}