package com.red_velvet.yumhub.data.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealValueDto(
    @SerializedName("ingredients")
    val ingredients: List<AddMealIngredient>? = listOf()
)