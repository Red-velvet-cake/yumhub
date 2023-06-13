package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealValueResource(
    @SerializedName("ingredients")
    val ingredients: List<AddMealIngredientResource>? = listOf()
)