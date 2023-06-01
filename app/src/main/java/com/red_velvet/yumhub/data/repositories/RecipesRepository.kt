package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.entities.RecipeEntity
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RecipesRepository {

    suspend fun searchRecipe(
        query: String? = null,
        sort: String? = null,
    ): Response<RecipeSearchDto>

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = null,
    ): Response<RecipeInformationDto>

    suspend fun getSimilarRecipes(
        id: Int,
        number: Int? = 3,
    ): Response<SimilarRecipesDto>

    suspend fun getRandomRecipes(
        tags: String? = "",
        number: Int? = 10
    ): Response<RandomRecipesDto>

    suspend fun guessNutrition(
        title: String = ""
    ): Response<GuessNutritionDto>

    suspend fun getQuickAnswer(
        question: String = ""
    ): Response<QuickAnswerDto>

    suspend fun refreshRecipes(recipeType: String)

    fun getRecipes(recipeType: String): Flow<List<RecipeEntity>>


}