package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class CaloricBreakdownDto(
    @SerializedName("percentCarbs")
    val percentCarbs: Double? = null,
    @SerializedName("percentFat")
    val percentFat: Double? = null,
    @SerializedName("percentProtein")
    val percentProtein: Double? = null
)