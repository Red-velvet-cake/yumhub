package com.red_velvet.yumhub.data.remote.dtos


import com.google.gson.annotations.SerializedName

data class StepDto(
    @SerializedName("equipment")
    val equipment: List<EquipmentDto?>? = null,
    @SerializedName("ingredients")
    val ingredients: List<IngredientDto?>? = null,
    @SerializedName("length")
    val length: LengthDto? = null,
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)