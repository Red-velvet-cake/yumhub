package com.red_velvet.yumhub.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class GuessNutritionDto(
    @SerializedName("calories")
    val caloriesDto: com.red_velvet.yumhub.remote.dtos.CaloriesDto? = com.red_velvet.yumhub.remote.dtos.CaloriesDto(),
    @SerializedName("carbs")
    val carbs: com.red_velvet.yumhub.remote.dtos.CaloriesDto? = com.red_velvet.yumhub.remote.dtos.CaloriesDto(),
    @SerializedName("fat")
    val fat: com.red_velvet.yumhub.remote.dtos.CaloriesDto? = com.red_velvet.yumhub.remote.dtos.CaloriesDto(),
    @SerializedName("protein")
    val protein: com.red_velvet.yumhub.remote.dtos.CaloriesDto? = com.red_velvet.yumhub.remote.dtos.CaloriesDto(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)