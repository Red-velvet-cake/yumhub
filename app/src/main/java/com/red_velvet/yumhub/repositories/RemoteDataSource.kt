package com.red_velvet.yumhub.repositories

import com.red_velvet.yumhub.remote.resources.auth.ConnectUserDto
import com.red_velvet.yumhub.remote.resources.auth.UserInformationDto
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.remote.resources.meal_plan.AddMealDto
import com.red_velvet.yumhub.remote.resources.meal_plan.ResultAddToMealPlanDto
import com.red_velvet.yumhub.remote.resources.meal_plan.WeekMealPlanDto
import com.red_velvet.yumhub.remote.resources.recipe.GuessNutritionDto
import com.red_velvet.yumhub.remote.resources.recipe.QuickAnswerDto
import com.red_velvet.yumhub.remote.resources.recipe.RandomRecipesDto
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationDto
import com.red_velvet.yumhub.remote.resources.recipe.RecipeSearchPagination
import com.red_velvet.yumhub.remote.resources.recipe.SimilarRecipesDto

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
    ): RecipeSearchPagination

    suspend fun getRecipesByMealType(
        type: String? = "",
        addRecipeInformation: Boolean? = true
    ): RecipeSearchPagination

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = false
    ): RecipeInformationDto

    suspend fun getSimilarRecipes(id: Int, number: Int? = 3): SimilarRecipesDto

    suspend fun getRandomRecipes(tags: String? = "", number: Int? = 10): RandomRecipesDto

    suspend fun guessNutrition(title: String = ""): GuessNutritionDto

    suspend fun getQuickAnswer(question: String = ""): QuickAnswerDto

    suspend fun searchIngredients(
        query: String, sort: String? = "",
        intolerances: String? = "",
        number: Int? = 10,
    ): IngredientSearchDto

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = null
    ): IngredientInformationDto

    suspend fun getSubstitutesIngredient(ingredientName: String?): IngredientSubstituteDto

    suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): WeekMealPlanDto

    suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): ResultAddToMealPlanDto

    suspend fun connectUser(userData: UserInformationDto): ConnectUserDto

}