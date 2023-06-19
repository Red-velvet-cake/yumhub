package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class WinePairingResource(
    @SerializedName("pairedWines")
    val pairedWines: List<Any?>? = null,
    @SerializedName("pairingText")
    val pairingText: String? = null,
    @SerializedName("productMatches")
    val productMatches: List<Any?>? = null
)