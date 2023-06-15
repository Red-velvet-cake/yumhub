package com.red_velvet.yumhub.domain.mapper
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource

fun RecipeInformationResource.toRecipeSearchEntity(): SearchRecipeEntity {
    return SearchRecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
        imageType = imageType.orEmpty(),
        ingredientNumber=0,
        readyInMinutes = readyInMinutes.toString().orEmpty(),
        analyzedInstructions = analyzedInstructions?.map { it.toModel() }.orEmptyList(),
    )
}