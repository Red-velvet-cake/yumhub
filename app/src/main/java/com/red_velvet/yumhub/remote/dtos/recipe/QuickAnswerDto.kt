package com.red_velvet.yumhub.remote.dtos.recipe


import com.google.gson.annotations.SerializedName

data class QuickAnswerDto(
    @SerializedName("answer")
    val answer: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("type")
    val type: String? = null
)