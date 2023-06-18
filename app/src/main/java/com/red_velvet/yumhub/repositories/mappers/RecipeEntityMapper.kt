package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource

fun RecipeInformationResource.toRecipeEntity(): RecipeEntity {
    return RecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        imageUrl = image.orEmpty()
    )
}