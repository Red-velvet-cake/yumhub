package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class EquipmentDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("localizedName")
    val localizedName: String? = null,
    @SerializedName("name")
    val name: String? = null
)