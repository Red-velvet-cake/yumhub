package com.red_velvet.yumhub.domain

import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResource
import com.red_velvet.yumhub.domain.models.recipes.AnalyzedInstructionsEntity
import com.red_velvet.yumhub.domain.models.recipes.CategoryEntity
import com.red_velvet.yumhub.domain.models.recipes.GuessNutrition
import com.red_velvet.yumhub.domain.models.recipes.HealthyRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.PopularRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswer
import com.red_velvet.yumhub.domain.models.recipes.QuickRecipeEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation
import com.red_velvet.yumhub.domain.models.recipes.SimilarRecipe

interface RecipesRepository {

    suspend fun getPopularRecipes(sort: String): List<PopularRecipeEntity>

    suspend fun getHealthyRecipes(sort: String): List<HealthyRecipeEntity>

    suspend fun getQuickRecipes(sort: String): List<QuickRecipeEntity>

    suspend fun searchRecipe(
        query: String? = null,
        sort: String? = null,
    ): RecipeSearchResource

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = null,
    ): RecipeInformationDto

    suspend fun getAnalyzedRecipeInstructions(
        id: Int,
        stepBreakdown: Boolean? = false,
    ):List<AnalyzedInstructionsEntity>
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

    suspend fun refreshPopularRecipes(recipesList: List<PopularRecipeEntity>)

    suspend fun getPopularRecipesFromLocal(): List<PopularRecipeEntity>

    suspend fun refreshQuickRecipes(recipesList: List<QuickRecipeEntity>)

    suspend fun getQuickRecipesFromLocal(): List<QuickRecipeEntity>

    suspend fun refreshHealthyRecipes(recipesList: List<HealthyRecipeEntity>)

    suspend fun getHealthyRecipesFromLocal(): List<HealthyRecipeEntity>

    suspend fun refreshCategories(categoryEntities: List<CategoryEntity>)

    suspend fun getCategoriesFromLocal(): List<CategoryEntity>

    suspend fun getCategoriesFromRemote(): List<CategoryEntity>
}