package com.red_velvet.repository.resources


import com.google.gson.annotations.SerializedName

data class EquipmentResource(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("localizedName")
    val localizedName: String? = null,
    @SerializedName("name")
    val name: String? = null
)