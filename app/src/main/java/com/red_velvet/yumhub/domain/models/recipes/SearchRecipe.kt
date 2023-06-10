package com.red_velvet.yumhub.domain.models.recipes

data class SearchRecipe(
    val id:Int?,
    val title:String?,
    val image:String?,
    val imageType: String,
    val readyInMinutes:Int?,
    val preparationMinutes: Int,
    val pricePerServing: Double,
    val servings: Int,
    val summary: String,
    val cheap: Boolean,
    val cookingMinutes : Int,
    val cuisines: List<String>,
    val diets: List<String>,
    val dishTypes: List<String>,
    val glutenFree: Boolean,
    val healthScore: Int,
    val analyzedInstructions:List<AnalyzedInstructions>
)
