package com.red_velvet.yumhub.data.repositories

import android.util.Log
import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResource
import com.red_velvet.yumhub.data.repositories.mappers.toCategoryRecipeDto
import com.red_velvet.yumhub.data.repositories.mappers.toCategoryRecipeEntity
import com.red_velvet.yumhub.data.repositories.mappers.toEntity
import com.red_velvet.yumhub.data.repositories.mappers.toHealthyRecipeDto
import com.red_velvet.yumhub.data.repositories.mappers.toHealthyRecipeEntity
import com.red_velvet.yumhub.data.repositories.mappers.toPopularRecipeDto
import com.red_velvet.yumhub.data.repositories.mappers.toPopularRecipeEntity
import com.red_velvet.yumhub.data.repositories.mappers.toQuickRecipeDto
import com.red_velvet.yumhub.data.repositories.mappers.toQuickRecipeEntity
import com.red_velvet.yumhub.domain.RecipesRepository
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val recipeDao: RecipeDao,
    private val localDataSource: LocalDataSource
) : RecipesRepository {

    override suspend fun getPopularRecipes(sort: String): List<PopularRecipeEntity> {
        val response = foodService.searchRecipe(sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toPopularRecipeEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getHealthyRecipes(sort: String): List<HealthyRecipeEntity> {
        val response = foodService.searchRecipe(sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toHealthyRecipeEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickRecipes(sort: String): List<QuickRecipeEntity> {
        val response = foodService.searchRecipe(sort = sort)
        if (response.isSuccessful) {
            return response.body()?.results?.map { it.toQuickRecipeEntity() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }




    override suspend fun searchRecipe(
        query: String?,
        sort: String?,
        sortDirection:String?,

    ): RecipeSearchResource {
        val response = foodService.searchRecipe(query, sort)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            Log.e("AYA",response.toString())
            throw Exception(response.message())
        }
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationDto {
        val response = foodService.getRecipeInformation(id, includeNutrition)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): List<SimilarRecipe> {
        val response = foodService.getSimilarRecipes(id, number)
        if (response.isSuccessful) {
            return response.body()?.map { it.toModel() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): List<RecipeInformation> {
        val response = foodService.getRandomRecipes(tags, number)
        if (response.isSuccessful) {
            return response.body()?.recipes?.map { it.toModel() } ?: emptyList()
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun guessNutrition(title: String): GuessNutrition {
        val response = foodService.guessNutrition(title)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswer {
        val response = foodService.getQuickAnswer(question)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun refreshPopularRecipes(recipesList: List<PopularRecipeEntity>) {
        recipeDao.insertPopularRecipes(recipesList.map { it.toPopularRecipeDto() })
    }

    override suspend fun refreshQuickRecipes(recipesList: List<QuickRecipeEntity>) {
        recipeDao.insertQuickRecipes(recipesList.map { it.toQuickRecipeDto() })
    }

    override suspend fun refreshHealthyRecipes(recipesList: List<HealthyRecipeEntity>) {
        recipeDao.insertHealthyRecipes(recipesList.map { it.toHealthyRecipeDto() })
    }

    override suspend fun refreshCategories(categoryEntities: List<CategoryEntity>) {
        recipeDao.insertCategories(categoryEntities.map { it.toCategoryRecipeDto() })
    }

    override suspend fun getPopularRecipesFromLocal(): List<PopularRecipeEntity> {
        return recipeDao.getPopularRecipes().map { it.toPopularRecipeEntity() }
    }

    override suspend fun getQuickRecipesFromLocal(): List<QuickRecipeEntity> {
        return recipeDao.getQuickRecipes().map { it.toQuickRecipeDto() }
    }

    override suspend fun getHealthyRecipesFromLocal(): List<HealthyRecipeEntity> {
        return recipeDao.getHealthyRecipes().map { it.toHealthyRecipeEntity() }
    }


    override suspend fun getCategoriesFromLocal(): List<CategoryEntity> {
        return recipeDao.getCategories().map { it.toCategoryRecipeEntity() }
    }

    override suspend fun getCategoriesFromRemote(): List<CategoryEntity> {
        return localDataSource.getCategories().map { it.toEntity() }
    }

}