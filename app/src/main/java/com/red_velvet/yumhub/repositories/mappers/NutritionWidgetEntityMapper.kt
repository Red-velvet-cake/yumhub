package com.red_velvet.yumhub.repositories.mappers

import com.red_velvet.yumhub.domain.models.recipes.NutritionWidgetEntity
import com.red_velvet.yumhub.domain.models.recipes.NutritionalInfoEntity
import com.red_velvet.yumhub.domain.utils.orEmpty
import com.red_velvet.yumhub.domain.utils.orFalse
import com.red_velvet.yumhub.domain.utils.orZero
import com.red_velvet.yumhub.remote.resources.recipe.NutritionWidgetResource
import com.red_velvet.yumhub.remote.resources.recipe.NutritionalInfoResource

fun NutritionWidgetResource.toEntity(): NutritionWidgetEntity {
    return NutritionWidgetEntity(
        bad = bad.toEntityList(), good.toEntityList()
    )
}

fun NutritionalInfoResource.toEntity(): NutritionalInfoEntity {
    return NutritionalInfoEntity(
        amount = amount.orEmpty(),
        indented = indented.orFalse(),
        name = name.orEmpty(),
        percentOfDailyNeeds = percentOfDailyNeeds.orZero()
    )
}

fun List<NutritionalInfoResource?>?.toEntityList(): List<NutritionalInfoEntity> {
    return this?.map { it!!.toEntity() }?: emptyList()
}