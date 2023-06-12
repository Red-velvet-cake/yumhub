package com.red_velvet.yumhub.data.repositories


import com.red_velvet.yumhub.data.local.daos.RecipeDao
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResource
import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDtoItem
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {

    suspend fun searchRecipe(
        query: String? = null,
        sort: String? = null,
        sortDirection: String? = null,
    ): RecipeSearchResource

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = null,
    ): RecipeInformationDto

    suspend fun getSimilarRecipes(
        id: Int,
        number: Int? = 3,
    ): List<SimilarRecipesDtoItem>

    suspend fun getRandomRecipes(
        tags: String? = "",
        number: Int? = 10
    ): RandomRecipesDto

    suspend fun guessNutrition(
        title: String = ""
    ): GuessNutritionDto

    suspend fun getQuickAnswer(
        question: String = ""
    ): QuickAnswerDto

    suspend fun refreshRecipes(recipeType: String)


}