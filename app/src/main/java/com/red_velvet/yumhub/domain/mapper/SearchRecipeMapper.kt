package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResultDto
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe
import com.red_velvet.yumhub.domain.utils.orZero

fun RecipeSearchResultDto.toRecipeSearch(): SearchRecipe {
    return SearchRecipe(
        id = id.orZero(),
        title=title.orEmpty(),
        image = image.orEmpty(),
    )
}