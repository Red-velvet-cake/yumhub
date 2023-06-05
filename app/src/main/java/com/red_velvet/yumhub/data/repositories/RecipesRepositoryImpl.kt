package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.domain.mapper.toEntity
import com.red_velvet.yumhub.domain.mapper.toModel
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe
import com.red_velvet.yumhub.domain.utils.ExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val recipeDao: RecipeDao,
    private val exception: ExceptionHandler
) : RecipesRepository {

    override suspend fun searchRecipe(
        query: String?,
        sort: String?
    ): RecipeSearchDto {
        val response = foodService.searchRecipe(query, sort)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw exception.getException(response.code(), response.errorBody())
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
            throw exception.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): List<SimilarRecipe> {
        val response = foodService.getSimilarRecipes(id, number)
        if (response.isSuccessful) {
            return response.body()?.map { it.toModel() }!!
        } else {
            throw exception.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): List<RecipeInformation> {
        val response = foodService.getRandomRecipes(tags, number)
        if (response.isSuccessful) {
            return response.body()?.recipes?.map { it.toModel() }!!
        } else {
            throw exception.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun guessNutrition(title: String): GuessNutrition {
        val response = foodService.guessNutrition(title)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exception.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswer {
        val response = foodService.getQuickAnswer(question)
        if (response.isSuccessful) {
            return response.body()?.toModel()!!
        } else {
            throw exception.getException(response.code(), response.errorBody())
        }
    }

    override suspend fun refreshRecipes(recipeType: String) {
        foodService.searchRecipe(sort = recipeType).let { recipesResponse ->
            if (recipesResponse.isSuccessful) {
                recipesResponse.body()?.results?.map {
                    it.toEntity(recipeType)
                }.let {
                    recipeDao.insertRecipe(it!!)
                }
            }
        }
    }

    override fun getRecipes(recipeType: String): Flow<List<Recipe>> {
        return recipeDao.getRecipes(recipeType).map { recipeEntities ->
            recipeEntities.map {
                it.toModel()
            }
        }
    }

}