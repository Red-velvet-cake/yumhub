package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto

interface IngredientRepository {

    suspend fun searchIngredient(
        query: String,
        sort: String? = "asc",
        intolerances: String? = "",
        number: Int? = 1
    ): IngredientSearchDto

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = "",
    ): IngredientInformationDto

    suspend fun getSubstitutesIngredient(
        ingredientName: String
    ): IngredientSubstituteDto
}