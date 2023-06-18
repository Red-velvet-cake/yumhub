package com.red_velvet.yumhub.repositories.datasources

import com.red_velvet.yumhub.remote.resources.AnalyzedInstructionResource
import com.red_velvet.yumhub.remote.resources.auth.ConnectUserResource
import com.red_velvet.yumhub.remote.resources.auth.UserInformationResource
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientInformationResource
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSearchResource
import com.red_velvet.yumhub.remote.resources.ingredient.IngredientSubstituteResource
import com.red_velvet.yumhub.remote.resources.meal_plan.AddMealResource
import com.red_velvet.yumhub.remote.resources.meal_plan.ResultAddToMealPlanResource
import com.red_velvet.yumhub.remote.resources.meal_plan.WeekMealPlanResource
import com.red_velvet.yumhub.remote.resources.recipe.GuessNutritionResource
import com.red_velvet.yumhub.remote.resources.recipe.QuickAnswerResource
import com.red_velvet.yumhub.remote.resources.recipe.RandomRecipesResource
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource
import com.red_velvet.yumhub.remote.resources.recipe.RecipeSearchPaginationResource
import com.red_velvet.yumhub.remote.resources.recipe.SimilarRecipesResource

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
        addRecipeInformation: Boolean? = true,
    ): RecipeSearchPaginationResource

    suspend fun getRecipesByMealType(
        type: String? = "",
        addRecipeInformation: Boolean? = true,
        sort: String?
    ): RecipeSearchPaginationResource

    suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean? = false,
    ): RecipeInformationResource

    suspend fun getSimilarRecipes(id: Int, number: Int? = 3): SimilarRecipesResource

    suspend fun getRandomRecipes(tags: String? = "", number: Int? = 10): RandomRecipesResource

    suspend fun guessNutrition(title: String = ""): GuessNutritionResource

    suspend fun getQuickAnswer(question: String = ""): QuickAnswerResource

    suspend fun searchIngredients(
        query: String, sort: String? = "",
        intolerances: String? = "",
        number: Int? = 10,
    ): IngredientSearchResource

    suspend fun getIngredientInformation(
        id: Int,
        amount: Int? = null,
        unit: String? = null,
    ): IngredientInformationResource

    suspend fun getSubstitutesIngredient(ingredientName: String?): IngredientSubstituteResource

    suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String,
    ): WeekMealPlanResource

    suspend fun addToMealPlan(
        addToMeal: AddMealResource,
        username: String,
        hash: String,
    ): ResultAddToMealPlanResource

    suspend fun connectUser(userData: UserInformationResource): ConnectUserResource

    suspend fun getAnalyzedInstructions(
        id: Int,
        stepBreakdown: Boolean?,
    ): List<AnalyzedInstructionResource>

}