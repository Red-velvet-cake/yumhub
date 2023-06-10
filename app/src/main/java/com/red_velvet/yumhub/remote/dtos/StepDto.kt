package com.red_velvet.yumhub.remote.dtos


import com.google.gson.annotations.SerializedName

data class StepDto(
    @SerializedName("equipment")
    val equipment: List<com.red_velvet.yumhub.remote.dtos.EquipmentDto> = emptyList(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.dtos.IngredientDto?>? = null,
    @SerializedName("length")
    val length: com.red_velvet.yumhub.remote.dtos.LengthDto = com.red_velvet.yumhub.remote.dtos.LengthDto(),
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)