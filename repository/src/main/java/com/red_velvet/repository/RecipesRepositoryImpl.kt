package com.red_velvet.repository


import com.red_velvet.domain.models.recipes.GuessNutritionEntity
import com.red_velvet.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.repository.datasources.LocalDataSource
import com.red_velvet.repository.datasources.RemoteDataSource
import com.red_velvet.repository.entities.CategoryLocalDto
import com.red_velvet.repository.entities.HealthyRecipeLocalDto
import com.red_velvet.repository.entities.PopularRecipeLocalDto
import com.red_velvet.repository.entities.QuickRecipeLocalDto
import com.red_velvet.repository.mappers.toAnalyzedInstructionEntity
import com.red_velvet.repository.mappers.toCategoryEntity
import com.red_velvet.repository.mappers.toEntity
import com.red_velvet.repository.mappers.toHealthyRecipeEntity
import com.red_velvet.repository.mappers.toLocalDto
import com.red_velvet.repository.mappers.toPopularEntity
import com.red_velvet.repository.mappers.toQuickRecipeEntity
import com.red_velvet.repository.mappers.toRecipeEntity
import com.red_velvet.repository.mappers.toRecipeSearchEntity
import com.red_velvet.repository.mappers.toSimilarRecipeEntity
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

 class RecipesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : com.red_velvet.domain.repositories.RecipesRepository {

    override suspend fun getPopularRecipes(sort: String): List<com.red_velvet.domain.models.recipes
    .PopularRecipeEntity> {
        return remoteDataSource.searchRecipe(sort = sort).results
            ?.map(RecipeInformationResource::toPopularEntity)
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
        sortDirection: String?,
    ): List<com.red_velvet.domain.models.recipes.SearchRecipeEntity> {
        return remoteDataSource.searchRecipe(
            query = query,
            sort = sort,
            sortDirection = sortDirection
        ).results?.map(RecipeInformationResource::toRecipeSearchEntity)
            ?: emptyList()
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?,
    ): com.red_velvet.domain.models.recipes.RecipeInformationEntity {
        return remoteDataSource.getRecipeInformation(id, includeNutrition).toEntity()
    }

    override suspend fun getAnalyzedRecipeInstructions(
        id: Int,
        stepBreakdown: Boolean?,
    ): List<com.red_velvet.domain.models.recipes.AnalyzedInstructionsEntity> {
        return remoteDataSource.getAnalyzedInstructions(id, stepBreakdown)
            .toAnalyzedInstructionEntity()
    }

    override suspend fun getSimilarRecipes(
        id: Int,
        number: Int?,
    ): List<com.red_velvet.domain.models.recipes.SimilarRecipeEntity> {
        return remoteDataSource.getSimilarRecipes(id, number)
            .map(RecipeInformationResource::toSimilarRecipeEntity)
    }

    override suspend fun getRandomRecipes(
        tags: String?,
        number: Int?,
    ): List<com.red_velvet.domain.models.recipes.RecipeInformationEntity> {
        return remoteDataSource.getRandomRecipes(
            tags,
            number
        ).recipes?.map(RecipeInformationResource::toEntity) ?: emptyList()
    }

    override suspend fun guessNutrition(title: String): GuessNutritionEntity {
        return remoteDataSource.guessNutrition(title).toEntity()
    }

    override suspend fun getQuickAnswer(question: String): com.red_velvet.domain.models.recipes.QuickAnswerEntity {
        return remoteDataSource.getQuickAnswer(question).toEntity()
    }

    override suspend fun refreshPopularRecipes(recipesList: List<com.red_velvet.domain.models.recipes.PopularRecipeEntity>) {
        localDataSource.insertPopularRecipes(recipesList.map(com.red_velvet.domain.models.recipes.PopularRecipeEntity::toLocalDto))
    }

    override suspend fun refreshQuickRecipes(recipesList: List<com.red_velvet.domain.models.recipes.QuickRecipeEntity>) {
        localDataSource.insertQuickRecipes(recipesList.map(com.red_velvet.domain.models.recipes.QuickRecipeEntity::toLocalDto))
    }

    override suspend fun refreshHealthyRecipes(recipesList: List<com.red_velvet.domain.models.recipes.HealthyRecipeEntity>) {
        localDataSource.insertHealthyRecipes(recipesList.map(com.red_velvet.domain.models.recipes.HealthyRecipeEntity::toLocalDto))
    }

    override suspend fun getPopularRecipesFromLocal(): Flow<List<com.red_velvet.domain.models.recipes.PopularRecipeEntity>> {
        return localDataSource.getPopularRecipes().map(List<PopularRecipeLocalDto>::toEntity)
    }

    override suspend fun getQuickRecipesFromLocal(): Flow<List<com.red_velvet.domain.models.recipes.QuickRecipeEntity>> {
        return localDataSource.getQuickRecipes().map(List<QuickRecipeLocalDto>::toEntity)
    }

    override suspend fun getHealthyRecipesFromLocal(): Flow<List<com.red_velvet.domain.models.recipes.HealthyRecipeEntity>> {
        return localDataSource.getHealthyRecipes().map(List<HealthyRecipeLocalDto>::toEntity)
    }

    override suspend fun getCategoriesFromRemote(): List<com.red_velvet.domain.models.recipes.CategoryEntity> {
        return localDataSource.getCategories().map(CategoryLocalDto::toCategoryEntity)
    }

    override suspend fun getSingleRecipeCategory(categoryType: String): List<com.red_velvet.domain.models.recipes.RecipeEntity> {
        return remoteDataSource.getRecipesByMealType(type = categoryType).results?.map(
            RecipeInformationResource::toRecipeEntity
        ) ?: emptyList()
    }

}