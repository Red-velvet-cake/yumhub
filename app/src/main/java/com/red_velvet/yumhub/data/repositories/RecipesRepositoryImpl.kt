package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.FoodService
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDto
import com.red_velvet.yumhub.domain.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val recipeDao: RecipeDao
) : RecipesRepository {

    override suspend fun searchRecipe(
        query: String?,
        sort: String?
    ): Response<RecipeSearchDto> {
        return foodService.searchRecipe(query, sort)
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): Response<RecipeInformationDto> {
        return foodService.getRecipeInformation(id, includeNutrition)
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): Response<SimilarRecipesDto> {
        return foodService.getSimilarRecipes(id, number)
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): Response<RandomRecipesDto> {
        return foodService.getRandomRecipes(tags, number)
    }

    override suspend fun guessNutrition(title: String): Response<GuessNutritionDto> {
        return foodService.guessNutrition(title)
    }

    override suspend fun getQuickAnswer(question: String): Response<QuickAnswerDto> {
        return foodService.getQuickAnswer(question)
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
        return recipeDao.getRecipe(recipeType)
    }

}