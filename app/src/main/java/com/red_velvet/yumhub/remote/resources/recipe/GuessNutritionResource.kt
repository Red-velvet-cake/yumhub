package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class GuessNutritionResource(
    @SerializedName("calories")
    val caloriesResource: com.red_velvet.yumhub.remote.resources.CaloriesResource? = com.red_velvet.yumhub.remote.resources.CaloriesResource(),
    @SerializedName("carbs")
    val carbs: com.red_velvet.yumhub.remote.resources.CaloriesResource? = com.red_velvet.yumhub.remote.resources.CaloriesResource(),
    @SerializedName("fat")
    val fat: com.red_velvet.yumhub.remote.resources.CaloriesResource? = com.red_velvet.yumhub.remote.resources.CaloriesResource(),
    @SerializedName("protein")
    val protein: com.red_velvet.yumhub.remote.resources.CaloriesResource? = com.red_velvet.yumhub.remote.resources.CaloriesResource(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)