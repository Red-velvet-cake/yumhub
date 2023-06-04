package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.domain.models.IngredientSearch
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformation

interface IngredientRepository {

    suspend fun searchIngredient(
        query: String,
        sort: String? = "asc",
        intolerances: String? = "",
        number: Int? = 1
    ): List<IngredientSearch>

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = "",
    ): IngredientInformation

    suspend fun getSubstitutesIngredient(
        ingredientName: String
    ): IngredientSubstitutes
}