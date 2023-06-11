package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class WinePairingDto(
    @SerializedName("pairedWines")
    val pairedWines: List<Any?>? = null,
    @SerializedName("pairingText")
    val pairingText: String? = null,
    @SerializedName("productMatches")
    val productMatches: List<Any?>? = null
)