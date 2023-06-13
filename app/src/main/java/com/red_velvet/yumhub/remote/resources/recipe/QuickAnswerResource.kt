package com.red_velvet.yumhub.remote.resources.recipe


import com.google.gson.annotations.SerializedName

data class QuickAnswerResource(
    @SerializedName("answer")
    val answer: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("type")
    val type: String? = null
)