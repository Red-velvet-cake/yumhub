package com.red_velvet.repository.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealIngredientResource(
    @SerializedName("name")
    val name: String? = null
)