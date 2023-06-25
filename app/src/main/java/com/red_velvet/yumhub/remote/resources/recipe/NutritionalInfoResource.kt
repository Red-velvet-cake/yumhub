package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class NutritionalInfoResource(
    @SerializedName("amount")
    val amount: String? = null,
    @SerializedName("indented")
    val indented: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentOfDailyNeeds")
    val percentOfDailyNeeds: Double? = null
)