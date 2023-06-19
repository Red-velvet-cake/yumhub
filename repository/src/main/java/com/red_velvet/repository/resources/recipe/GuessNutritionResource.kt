package com.red_velvet.repository.resources.recipe


import com.google.gson.annotations.SerializedName

data class GuessNutritionResource(
    @SerializedName("calories")
    val caloriesResource: com.red_velvet.repository.resources.CaloriesResource? = com.red_velvet.repository.resources.CaloriesResource(),
    @SerializedName("carbs")
    val carbs: com.red_velvet.repository.resources.CaloriesResource? = com.red_velvet.repository.resources.CaloriesResource(),
    @SerializedName("fat")
    val fat: com.red_velvet.repository.resources.CaloriesResource? = com.red_velvet.repository.resources.CaloriesResource(),
    @SerializedName("protein")
    val protein: com.red_velvet.repository.resources.CaloriesResource? = com.red_velvet.repository.resources.CaloriesResource(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)