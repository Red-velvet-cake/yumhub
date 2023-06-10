package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.IngredientDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResultDto
import com.red_velvet.yumhub.domain.models.recipes.Ingredients
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipe
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orEmptyList
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero

fun RecipeSearchResultDto.toRecipeSearchResult(): SearchRecipe {
    return SearchRecipe(
        id = id.orZero(),
        image = image.orEmpty(),
        imageType = imageType.orEmpty(),
        preparationMinutes = preparationMinutes.orZero(),
        pricePerServing = pricePerServing.orZero(),
        readyInMinutes = readyInMinutes.orZero(),
        servings = servings.orZero(),
        summary = summary.orEmpty(),
        title = title.orEmpty(),
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
fun IngredientDto.toModel(): Ingredients {
    return Ingredients(
        id = id.orZero(),
        image = image.orEmpty(),
        localizedName = localizedName.orEmpty(),
        name = name.orEmpty()
    )
}