package com.red_velvet.yumhub.ui.recipeDetails

interface RecipeInformationInteractionListener {

    fun onShowRecipeCookingStepsClicked(recipeId: Int)

    fun onAddToMealPlan(recipeId: Int)

}