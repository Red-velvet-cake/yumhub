package com.red_velvet.yumhub.repositories


import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.local.entities.CategoryLocalDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto
import com.red_velvet.yumhub.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.remote.dtos.recipe.RecipeSearchPagination
import com.red_velvet.yumhub.repositories.mappers.toEntity
import com.red_velvet.yumhub.repositories.mappers.toLocalDto
import com.red_velvet.yumhub.repositories.mappers.toPopularEntity
import com.red_velvet.yumhub.repositories.mappers.toQuickRecipeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : RecipesRepository {

    override suspend fun getPopularRecipes(sort: String): List<PopularRecipeEntity> {
        val response = remoteDataSource.searchRecipe(sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toPopularEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getHealthyRecipesFromRemote(sort: String): List<HealthyRecipeEntity> {
        val response = remoteDataSource.searchRecipe(sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickRecipes(sort: String): List<QuickRecipeEntity> {
        val response = remoteDataSource.searchRecipe(sort = sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toQuickRecipeEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun searchRecipe(
        query: String?,
        sort: String?
    ): RecipeSearchPagination {
        val response = remoteDataSource.searchRecipe(query, sort)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationDto {
        val response = remoteDataSource.getRecipeInformation(id, includeNutrition)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): List<SimilarRecipeEntity> {
        val response = remoteDataSource.getSimilarRecipes(id, number)
        if (response.isSuccessful) {
            return response.body()?.map { it.toModel() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): List<RecipeInformationEntity> {
        val response = remoteDataSource.getRandomRecipes(tags, number)
        if (response.isSuccessful) {
            return response.body()?.recipes?.map { it.toModel() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun guessNutrition(title: String): GuessNutritionEntity {
        val response = remoteDataSource.guessNutrition(title)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswerEntity {
        val response = remoteDataSource.getQuickAnswer(question)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun refreshPopularRecipes(recipesList: List<PopularRecipeEntity>) {
        localDataSource.insertPopularRecipes(recipesList.map(PopularRecipeEntity::toLocalDto))
    }

    override suspend fun refreshQuickRecipes(recipesList: List<QuickRecipeEntity>) {
        localDataSource.insertQuickRecipes(recipesList.map(QuickRecipeEntity::toLocalDto))
    }

    override suspend fun refreshHealthyRecipes(recipesList: List<HealthyRecipeEntity>) {
        localDataSource.insertHealthyRecipes(recipesList.map(HealthyRecipeEntity::toLocalDto))
    }

    override suspend fun getPopularRecipesFromLocal(): Flow<List<PopularRecipeEntity>> {
        return localDataSource.getPopularRecipes().map(List<PopularRecipeLocalDto>::toEntity)
    }

    override suspend fun getQuickRecipesFromLocal(): Flow<List<QuickRecipeEntity>> {
        return localDataSource.getQuickRecipes().map(List<QuickRecipeLocalDto>::toEntity)
    }

    override suspend fun getHealthyRecipesFromLocal(): Flow<List<HealthyRecipeEntity>> {
        return localDataSource.getHealthyRecipes().map(List<HealthyRecipeLocalDto>::toEntity)
    }

    override suspend fun getCategoriesFromRemote(): List<CategoryEntity> {
        return localDataSource.getCategories().map(CategoryLocalDto::toEntity)
    }

}