package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealValueDto(
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.resources.meal_plan.AddMealIngredient>? = listOf()
)