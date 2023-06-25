package com.red_velvet.yumhub.ui.recipeDetails

import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity


fun RecipeInformationEntity.map(): RecipeInformationUIState {
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

fun RecipeInformationEntity.toDishTypeUIState(): List<DishTypeUIState> {
    return this.dishTypes.map {
        DishTypeUIState(
            dishType = it
        )
    }
}

fun RecipeInformationEntity.toIngredientsUIState(): List<IngredientsUIState> {
    return extendedIngredientEntities.map { extendedIngredient ->
        IngredientsUIState(
            image = extendedIngredient.image,
            name = extendedIngredient.original
        )
    }
}