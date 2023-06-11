package com.red_velvet.yumhub.remote.resources


import com.google.gson.annotations.SerializedName

data class StepDto(
    @SerializedName("equipment")
    val equipment: List<com.red_velvet.yumhub.remote.resources.EquipmentDto> = emptyList(),
    @SerializedName("ingredients")
    val ingredients: List<com.red_velvet.yumhub.remote.resources.IngredientDto?>? = null,
    @SerializedName("length")
    val length: com.red_velvet.yumhub.remote.resources.LengthDto = com.red_velvet.yumhub.remote.resources.LengthDto(),
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("step")
    val step: String? = null
)