package com.red_velvet.yumhub.data.remote.dtos.recipe


import com.google.gson.annotations.SerializedName
import com.red_velvet.yumhub.data.remote.dtos.CaloriesDto
import com.red_velvet.yumhub.data.remote.dtos.CarbsDto
import com.red_velvet.yumhub.data.remote.dtos.FatDto
import com.red_velvet.yumhub.data.remote.dtos.ProteinDto

data class GuessNutritionDto(
    @SerializedName("calories")
    val calories: CaloriesDto? = CaloriesDto(),
    @SerializedName("carbs")
    val carbs: CarbsDto? = CarbsDto(),
    @SerializedName("fat")
    val fat: FatDto? = FatDto(),
    @SerializedName("protein")
    val protein: ProteinDto? = ProteinDto(),
    @SerializedName("recipesUsed")
    val recipesUsed: Int? = 0
)