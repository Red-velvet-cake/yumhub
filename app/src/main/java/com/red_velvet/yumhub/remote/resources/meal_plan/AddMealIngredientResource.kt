package com.red_velvet.yumhub.remote.resources.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealIngredientResource(
    @SerializedName("name")
    val name: String? = null
)