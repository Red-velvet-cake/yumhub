package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDtoItem
import com.red_velvet.yumhub.domain.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val recipeDao: RecipeDao
) : RecipesRepository {

    override suspend fun searchRecipe(
        query: String?,
        sort: String?
    ): RecipeSearchDto {
        val response = foodService.searchRecipe(query, sort)
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
        val response = foodService.getRecipeInformation(id, includeNutrition)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): List<SimilarRecipesDtoItem> {
        val response = foodService.getSimilarRecipes(id, number)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): RandomRecipesDto {
        val response = foodService.getRandomRecipes(tags, number)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun guessNutrition(title: String): GuessNutritionDto {
        val response = foodService.guessNutrition(title)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswerDto {
        val response = foodService.getQuickAnswer(question)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
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

    override fun getRecipes(recipeType: String): Flow<List<RecipeEntity>> {
        return recipeDao.getRecipes(recipeType)
    }

}