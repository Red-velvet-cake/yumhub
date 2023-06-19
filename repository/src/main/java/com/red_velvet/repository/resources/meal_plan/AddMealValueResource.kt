package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealValueResource(
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.repository.resources.meal_plan.AddMealIngredientResource>? = listOf()
)