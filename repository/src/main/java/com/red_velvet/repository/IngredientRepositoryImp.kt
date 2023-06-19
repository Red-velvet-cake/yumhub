package com.red_velvet.repository


import com.red_velvet.repository.datasources.RemoteDataSource
import com.red_velvet.repository.mappers.toIngredientInformation
import com.red_velvet.repository.mappers.toIngredientSearchResult
import com.red_velvet.repository.mappers.toIngredientSubstitute
import com.red_velvet.repository.resources.ingredient.IngredientSearchResultResource
import javax.inject.Inject

class IngredientRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : com.red_velvet.domain.repositories.IngredientRepository {
    override suspend fun searchIngredient(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): List<com.red_velvet.domain.models.IngredientSearchEntity> {
        return remoteDataSource.searchIngredients(query, sort, intolerances, number).results?.map(
            IngredientSearchResultResource::toIngredientSearchResult
        ) ?: emptyList()
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): com.red_velvet.domain.models.ingredientInformation.IngredientInformationEntity {
        return remoteDataSource.getIngredientInformation(id, amount, unit).toIngredientInformation()
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String): com.red_velvet.domain.models.IngredientSubstitutesEntity {
        return remoteDataSource.getSubstitutesIngredient(ingredientName).toIngredientSubstitute()
    }
}