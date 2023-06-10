package com.red_velvet.yumhub.remote.dtos.meal_plan


import com.google.gson.annotations.SerializedName

data class AddMealIngredient(
    @SerializedName("name")
    val name: String? = null
)