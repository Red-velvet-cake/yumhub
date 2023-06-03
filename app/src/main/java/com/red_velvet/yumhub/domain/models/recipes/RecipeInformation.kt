package com.red_velvet.yumhub.domain.models.recipes


data class RecipeInformation(
    val id: Int,
    val image: String,
    val imageType: String,
    val instructions: String,
    val preparationMinutes: Int,
    val pricePerServing: Double,
    val readyInMinutes: Int,
    val servings: Int,
    val summary: String,
    val title: String,
    val analyzedInstructions: List<Any?>? = null,
    val cheap: Boolean? = null,
    val cookingMinutes: Int,
    val cuisines: List<Any?>? = null,
    val diets: List<Any?>? = null,
    val dishTypes: List<String?>? = null,
    val extendedIngredients: List<ExtendedIngredient?>? = null,
    val glutenFree: Boolean? = null,
    val healthScore: Int,
)
