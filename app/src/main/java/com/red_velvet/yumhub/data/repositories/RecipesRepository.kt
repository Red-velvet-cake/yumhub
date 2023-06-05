package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchDto
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import com.red_velvet.yumhub.domain.models.recipes.Recipe
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {

    suspend fun searchRecipe(
        query: String? = null,
        sort: String? = null,
    ): RecipeSearchDto

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = null,
    ): RecipeInformationDto

    suspend fun getSimilarRecipes(
        id: Int,
        number: Int? = 3,
    ): List<SimilarRecipe>

    suspend fun getRandomRecipes(
        tags: String? = "",
        number: Int? = 10
    ): List<RecipeInformation>

    suspend fun guessNutrition(
        title: String = ""
    ): GuessNutrition

    suspend fun getQuickAnswer(
        question: String = ""
    ): QuickAnswer

    suspend fun refreshRecipes(recipeType: String)

    fun getRecipes(recipeType: String): Flow<List<Recipe>>
}