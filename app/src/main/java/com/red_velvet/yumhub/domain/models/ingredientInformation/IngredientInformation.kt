package com.red_velvet.yumhub.domain.models.ingredientInformation

data class IngredientInformation(
    val id:Int?,
    val name :String?,
    val image:String?,
    val categoryPath:List<String>?,
    val nutrition: Nutrition?
)







