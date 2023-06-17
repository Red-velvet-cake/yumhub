package com.red_velvet.yumhub.repositories


import com.red_velvet.yumhub.domain.mapper.toEntity
import com.red_velvet.yumhub.domain.mapper.toRecipeSearchEntity
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformationEntity
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipeEntity
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import com.red_velvet.yumhub.local.entities.CategoryLocalDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import com.red_velvet.yumhub.repositories.mappers.toAnalyzedInstructionEntity
import com.red_velvet.yumhub.repositories.mappers.toEntity
import com.red_velvet.yumhub.repositories.mappers.toHealthyRecipeEntity
import com.red_velvet.yumhub.repositories.mappers.toLocalDto
import com.red_velvet.yumhub.repositories.mappers.toPopularEntity
import com.red_velvet.yumhub.repositories.mappers.toQuickRecipeEntity
import com.red_velvet.yumhub.repositories.mappers.toRecipeEntity
import com.red_velvet.yumhub.repositories.mappers.toSimilarRecipeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : RecipesRepository {

    override suspend fun getPopularRecipes(sort: String): List<PopularRecipeEntity> {
        return remoteDataSource.searchRecipe(sort = sort).results?.map(RecipeInformationResource::toPopularEntity)
            ?: emptyList()
    }

    override suspend fun getHealthyRecipesFromRemote(sort: String): List<HealthyRecipeEntity> {
        return remoteDataSource.searchRecipe(sort = sort).results?.map(RecipeInformationResource::toHealthyRecipeEntity)
            ?: emptyList()
    }

    override suspend fun getQuickRecipes(sort: String): List<QuickRecipeEntity> {
        return remoteDataSource.searchRecipe(sort = sort).results?.map(RecipeInformationResource::toQuickRecipeEntity)
            ?: emptyList()
    }


    override suspend fun searchRecipe(
        query: String?,
        sort: String?,
        sortDirection: String?
    ): List<SearchRecipeEntity> {
        return remoteDataSource.searchRecipe(
            query = query,
            sort = sort,
            sortDirection = sortDirection
        ).results?.map(RecipeInformationResource::toRecipeSearchEntity)
            ?: emptyList()
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationEntity {
        return remoteDataSource.getRecipeInformation(id, includeNutrition).toEntity()
    }

    override suspend fun getAnalyzedRecipeInstructions(
        id: Int,
        stepBreakdown: Boolean?,
    ): List<AnalyzedInstructionsEntity> {
        return remoteDataSource.getAnalyzedInstructions(id,stepBreakdown).toAnalyzedInstructionEntity()
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): List<SimilarRecipeEntity> {
        return remoteDataSource.getSimilarRecipes(id, number)
            .map(RecipeInformationResource::toSimilarRecipeEntity)
    }

    override suspend fun getRandomRecipes(
        tags: String?,
        number: Int?
    ): List<RecipeInformationEntity> {
        return remoteDataSource.getRandomRecipes(
            tags,
            number
        ).recipes?.map(RecipeInformationResource::toEntity) ?: emptyList()
    }

    override suspend fun guessNutrition(title: String): GuessNutritionEntity {
        return remoteDataSource.guessNutrition(title).toEntity()
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswerEntity {
        return remoteDataSource.getQuickAnswer(question).toEntity()
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

    override suspend fun getSingleRecipeCategory(
        categoryType: String?,
        sort: String?
    ): List<RecipeEntity> {
        return remoteDataSource.getRecipesByMealType(type = categoryType, sort = sort).results?.map(
            RecipeInformationResource::toRecipeEntity
        ) ?: emptyList()
    }

}