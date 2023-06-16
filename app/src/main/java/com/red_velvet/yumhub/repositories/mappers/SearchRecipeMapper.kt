package com.red_velvet.yumhub.domain.mapper
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource

fun RecipeInformationResource.toRecipeSearchEntity(): SearchRecipeEntity {
    return SearchRecipeEntity(
        id = id.orZero(),
        title = title.orEmpty(),
        image = image.orEmpty(),
        imageType = imageType.orEmpty(),
        preparationMinutes = preparationMinutes.orZero(),
        pricePerServing = pricePerServing.orZero(),
        readyInMinutes = readyInMinutes.orZero(),
        servings = servings.orZero(),
        summary = summary.orEmpty(),
        analyzedInstructions = analyzedInstructions?.map { it.toModel() }.orEmptyList(),
        cheap = cheap.orFalse(),
        cookingMinutes =cookingMinutes.orZero(),
        cuisines =cuisines.orEmptyList(),
        diets = diets.orEmptyList(),
        dishTypes = dishTypes.orEmptyList(),
        glutenFree = glutenFree.orFalse(),
        healthScore = healthScore.orZero()

    )

}