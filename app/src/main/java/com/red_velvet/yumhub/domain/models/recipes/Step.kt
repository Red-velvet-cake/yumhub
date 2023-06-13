package com.red_velvet.yumhub.domain.models.recipes

import com.red_velvet.yumhub.remote.resources.EquipmentResource
import com.red_velvet.yumhub.remote.resources.LengthResource


data class Step(
    val equipment: List<EquipmentResource>,
    val length: LengthResource,
    val number: Int,
    val step: String,
    val ingredients :List<IngredientsEntity>
)
