package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.remote.dtos.auth.ConnectUserDto
import com.red_velvet.yumhub.remote.dtos.auth.UserInformationDto
import com.red_velvet.yumhub.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.remote.dtos.meal_plan.ResultAddToMealPlanDto
import com.red_velvet.yumhub.remote.dtos.meal_plan.WeekMealPlanDto
import com.red_velvet.yumhub.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.remote.dtos.recipe.RecipeSearchPagination
import com.red_velvet.yumhub.remote.dtos.recipe.SimilarRecipesDto
import retrofit2.Response

interface RemoteDataSource {

    suspend fun searchRecipe(
        query: String? = "",
        cuisine: String? = "",
        intolerances: String? = "",
        diet: String? = "",
        excludeCuisine: String? = "",
        includeIngredients: String? = "",
        excludeIngredients: String? = "",
        sort: String? = "",
        sortDirection: String? = "asc",
        addRecipeInformation: Boolean? = true
    ): Response<RecipeSearchPagination>

    suspend fun getRecipesByMealType(
        type: String? = "",
        addRecipeInformation: Boolean? = true
    ): Response<RecipeSearchPagination>

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = false
    ): Response<RecipeInformationDto>

    suspend fun getSimilarRecipes(id: Int, number: Int? = 3): Response<SimilarRecipesDto>

    suspend fun getRandomRecipes(tags: String? = "", number: Int? = 10): Response<RandomRecipesDto>

    suspend fun guessNutrition(title: String = ""): Response<GuessNutritionDto>

    suspend fun getQuickAnswer(question: String = ""): Response<QuickAnswerDto>

    suspend fun searchIngredients(
        query: String, sort: String? = "",
        intolerances: String? = "",
        number: Int? = 10,
    ): Response<IngredientSearchDto>

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = null
    ): Response<IngredientInformationDto>

    suspend fun getSubstitutesIngredient(ingredientName: String?): Response<IngredientSubstituteDto>

    suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): Response<WeekMealPlanDto>

    suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): Response<ResultAddToMealPlanDto>

    suspend fun connectUser(userData: UserInformationDto): Response<ConnectUserDto>

}