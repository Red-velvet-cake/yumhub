package com.red_velvet.repository.mappers
import com.red_velvet.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import com.red_velvet.repository.utils.orEmptyList
import com.red_velvet.repository.utils.orFalse
import com.red_velvet.repository.utils.orZero

internal fun RecipeInformationResource.toRecipeSearchEntity(): SearchRecipeEntity {
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
        cookingMinutes = cookingMinutes.orZero(),
        cuisines = cuisines.orEmptyList(),
        diets = diets.orEmptyList(),
        dishTypes = dishTypes.orEmptyList(),
        glutenFree = glutenFree.orFalse(),
        healthScore = healthScore.orZero()

    )

}