package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.mapper.toIngredientInformation
import com.red_velvet.yumhub.domain.mapper.toIngredientSearchResult
import com.red_velvet.yumhub.domain.mapper.toIngredientSubstitute
import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.yumhub.domain.repositories.IngredientRepository
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): List<IngredientSearchEntity> {
        val response = remoteDataSource.searchIngredients(
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
    ): IngredientInformationEntity {
        val response = remoteDataSource.getIngredientInformation(id)
        if (response.isSuccessful) {
            return response.body()?.toIngredientInformation()!!
        } else {
            throw Exception(response.message())
        }

    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): IngredientSubstitutesEntity {
        val response = remoteDataSource.getSubstitutesIngredient(ingredientName = ingredientName)
        if (response.isSuccessful) {
            return response.body()?.toIngredientSubstitute()!!
        } else {
            throw Exception(response.message())
        }
    }
}