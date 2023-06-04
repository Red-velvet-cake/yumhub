package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.CaloriesDto

data class GuessNutritionDto(
    @SerializedName("calories")
    val caloriesDto: CaloriesDto? = CaloriesDto(),
    @SerializedName("carbs")
    val carbs: CaloriesDto? = CaloriesDto(),
    @SerializedName("fat")
    val fat: CaloriesDto? = CaloriesDto(),
    @SerializedName("protein")
    val protein: CaloriesDto? = CaloriesDto(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)