package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.domain.mapper.toIngredientInformation
import com.red_velvet.yumhub.domain.mapper.toIngredientSearchResult
import com.red_velvet.yumhub.domain.mapper.toIngredientSubstitute
import com.red_velvet.yumhub.domain.models.IngredientSearch
import com.red_velvet.yumhub.domain.models.IngredientSubstitutes
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformation
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val foodService: FoodService,
) : IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): List<IngredientSearch> {
        val response = foodService.searchIngredients(
            query = query,
            sort = sort,
        )
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toIngredientSearchResult() }!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformation {
        val response = foodService.getIngredientInformation(id)
        if (response.isSuccessful) {
            return response.body()?.toIngredientInformation()!!
        } else {
            throw Exception(response.message())
        }

    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): IngredientSubstitutes {
        val response = foodService.getSubstitutesIngredient(ingredientName = ingredientName)
        if (response.isSuccessful) {
            return response.body()?.toIngredientSubstitute()!!
        } else {
            throw Exception(response.message())
        }
    }
}