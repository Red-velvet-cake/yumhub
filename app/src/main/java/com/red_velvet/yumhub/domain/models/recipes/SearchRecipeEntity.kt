package com.red_velvet.yumhub.domain.models.recipes

data class SearchRecipeEntity(
    val id:Int?,
    val title:String?,
    val image:String?,
    val imageType: String,
    val readyInMinutes:String,
    val ingredientNumber:Int,
    val analyzedInstructions:List<AnalyzedInstructionsEntity>
)
