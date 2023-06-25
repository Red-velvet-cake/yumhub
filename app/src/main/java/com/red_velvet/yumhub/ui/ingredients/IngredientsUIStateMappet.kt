package com.red_velvet.yumhub.ui.ingredients

import com.red_velvet.yumhub.domain.models.recipes.ExtendedIngredientEntity
import com.red_velvet.yumhub.domain.utils.orEmpty


fun ExtendedIngredientEntity.toExtendedIngredientsUIState(): ExtendedIngredientUIState {
    return ExtendedIngredientUIState(
        image = "https://spoonacular.com/cdn/ingredients_100x100/${this.image}".orEmpty(),
        original = this.original.orEmpty()
    )

}