package com.red_velvet.yumhub.domain.models.recipes


data class RecipeInformationEntity(
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
    val analyzedInstructionEntities: List<AnalyzedInstructionsEntity>,
    val cheap: Boolean,
    val cookingMinutes : Int,
    val cuisines: List<String>,
    val diets: List<String>,
    val dishTypes: List<String>,
    val extendedIngredientEntities: List<ExtendedIngredientEntity>,
    val glutenFree: Boolean,
    val healthScore: Int,
)
