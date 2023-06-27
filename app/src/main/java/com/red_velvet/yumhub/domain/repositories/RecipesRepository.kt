package com.red_velvet.yumhub.domain.repositories


import com.red_velvet.yumhub.domain.models.SliderItemEntity
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
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {

    suspend fun getDietRecipe(type:String) :List<SearchRecipeEntity>

    suspend fun getPopularRecipes(sort: String): List<PopularRecipeEntity>

    suspend fun getHealthyRecipesFromRemote(sort: String): List<HealthyRecipeEntity>

    suspend fun getQuickRecipes(sort: String): List<QuickRecipeEntity>

    suspend fun searchRecipe(
        query: String? = null,
        sort: String? = null,
        sortDirection: String? = null,
    ): List<SearchRecipeEntity>


    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = null,
    ): RecipeInformationEntity

    suspend fun getAnalyzedRecipeInstructions(
        id: Int,
        stepBreakdown: Boolean? = false,
    ):List<AnalyzedInstructionsEntity>
    suspend fun getSimilarRecipes(
        id: Int,
        number: Int? = 3,
    ): List<SimilarRecipeEntity>

    suspend fun getRandomRecipes(
        tags: String? = "",
        number: Int? = 10
    ): List<RecipeInformationEntity>

    suspend fun guessNutrition(
        title: String = ""
    ): GuessNutritionEntity

    suspend fun getQuickAnswer(
        question: String = ""
    )

    suspend fun getAllChatBotMessages(): Flow<List<QuickAnswerEntity>>

    suspend fun refreshPopularRecipes(recipesList: List<PopularRecipeEntity>)

    suspend fun getPopularRecipesFromLocal(): Flow<List<PopularRecipeEntity>>

    suspend fun refreshQuickRecipes(recipesList: List<QuickRecipeEntity>)

    suspend fun getQuickRecipesFromLocal(): Flow<List<QuickRecipeEntity>>

    suspend fun refreshHealthyRecipes(recipesList: List<HealthyRecipeEntity>)

    suspend fun getHealthyRecipesFromLocal(): Flow<List<HealthyRecipeEntity>>

    suspend fun getCategoriesFromRemote(): List<CategoryEntity>

    suspend fun getSingleRecipeCategory(categoryType: String?, sort: String?): List<RecipeEntity>

    suspend fun getHomeSliderImagesList(): List<SliderItemEntity>
}