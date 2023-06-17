package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.domain.models.IngredientSearchEntity
import com.red_velvet.yumhub.domain.models.IngredientSubstitutesEntity
import com.red_velvet.yumhub.domain.models.ingredientInformation.IngredientInformationEntity
import com.red_velvet.yumhub.domain.repositories.IngredientRepository
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchResultResource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.mappers.toIngredientInformation
import com.red_velvet.yumhub.repositories.mappers.toIngredientSearchResult
import com.red_velvet.yumhub.repositories.mappers.toIngredientSubstitute
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
        return remoteDataSource.searchIngredients(query, sort, intolerances, number).results?.map(
            IngredientSearchResultResource::toIngredientSearchResult
        ) ?: emptyList()
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformationEntity {
        return remoteDataSource.getIngredientInformation(id, amount, unit).toIngredientInformation()
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): IngredientSubstitutesEntity {
        return remoteDataSource.getSubstitutesIngredient(ingredientName).toIngredientSubstitute()
    }
}