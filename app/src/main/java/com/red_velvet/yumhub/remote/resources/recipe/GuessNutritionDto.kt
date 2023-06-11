package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class GuessNutritionDto(
    @SerializedName("calories")
    val caloriesDto: com.red_velvet.yumhub.remote.resources.CaloriesDto? = com.red_velvet.yumhub.remote.resources.CaloriesDto(),
    @SerializedName("carbs")
    val carbs: com.red_velvet.yumhub.remote.resources.CaloriesDto? = com.red_velvet.yumhub.remote.resources.CaloriesDto(),
    @SerializedName("fat")
    val fat: com.red_velvet.yumhub.remote.resources.CaloriesDto? = com.red_velvet.yumhub.remote.resources.CaloriesDto(),
    @SerializedName("protein")
    val protein: com.red_velvet.yumhub.remote.resources.CaloriesDto? = com.red_velvet.yumhub.remote.resources.CaloriesDto(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)