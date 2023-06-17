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
    val analyzedInstructions: List<AnalyzedInstructions>,
    val cheap: Boolean,
    val cookingMinutes: Int,
    val cuisines: List<String>,
    val diets: List<String>,
    val dishTypes: List<String>,
    val extendedIngredients: List<ExtendedIngredient>,
    val glutenFree: Boolean,
    val healthScore: Int,
    val description: String,
)
