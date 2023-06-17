package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation

fun RecipeInformation.map(): RecipeInformationUIState {
    return RecipeInformationUIState(
        image = this.image,
        title = this.title,
        readyInMinutes = this.readyInMinutes,
        servings = this.servings,
        dishTypeUIState = this.toDishTypeUIState(),
        description = this.description,
        ingredientsUIState = this.toIngredientsUIState()
    )
}

fun RecipeInformation.toDishTypeUIState(): List<DishTypeUIState> {
    return this.dishTypes.map {
        DishTypeUIState(
            dishType = it
        )
    }
}

fun RecipeInformation.toIngredientsUIState(): List<IngredientsUIState> {
    return this.extendedIngredients.map { extendedIngredient ->
        IngredientsUIState(
            image = extendedIngredient.image,
            original = extendedIngredient.original
        )
    }
}