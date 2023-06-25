package com.red_velvet.yumhub.domain.models.recipes

import com.google.gson.annotations.SerializedName

data class NutritionalInfoEntity(
    val amount: String,
    val indented: Boolean,
    val name: String,
    val percentOfDailyNeeds: Double
)

