package com.red_velvet.yumhub.remote

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
import com.red_velvet.yumhub.remote.resources.recipe.RecipesByRangeOfCaloriesResource
import com.red_velvet.yumhub.remote.resources.recipe.SimilarRecipesResource
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodService {

    @GET("recipes/complexSearch")
    suspend fun searchRecipe(
        @Query("query") query: String? = "",
        @Query("cuisine") cuisine: String? = "",
        @Query("intolerances") intolerances: String? = "",
        @Query("diet") diet: String? = "",
        @Query("excludeCuisine") excludeCuisine: String? = "",
        @Query("includeIngredients") includeIngredients: String? = "",
        @Query("excludeIngredients") excludeIngredients: String? = "",
        @Query("sort") sort: String? = "",
        @Query("sortDirection") sortDirection: String? = "",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true,
    ): Response<RecipeSearchPaginationResource>

    @GET("recipes/complexSearch")
    suspend fun getRecipesByMealType(
        @Query("type") type: String? = "",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true,
        @Query("sort") sort: String? = ""
    ): Response<RecipeSearchPaginationResource>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean? = false
    ): Response<RecipeInformationResource>

    @GET("recipes/{id}/similar")
    suspend fun getSimilarRecipes(
        @Path("id") id: Int,
        @Query("number") number: Int? = 3
    ): Response<SimilarRecipesResource>

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("tags") tags: String? = "",
        @Query("number") number: Int? = 10
    ): Response<RandomRecipesResource>

    @GET("recipes/guessNutrition")
    suspend fun guessNutrition(
        @Query("title") title: String = ""
    ): Response<GuessNutritionResource>

    @GET("recipes/quickAnswer")
    suspend fun getQuickAnswer(
        @Query("q") question: String = ""
    ): Response<QuickAnswerResource>

    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("sort") sort: String? = "",
        @Query("intolerances") intolerances: String? = "",
        @Query("number") number: Int? = 10
    ): Response<IngredientSearchResource>

    @GET("food/ingredients/{id}/information")
    suspend fun getIngredientInformation(
        @Path("id") id: Int,
        @Query("amount") amount: Int? = null,
        @Query("unit") unit: String? = null
    ): Response<IngredientInformationResource>

    @GET("food/ingredients/substitutes")
    suspend fun getSubstitutesIngredient(
        @Query("ingredientName") ingredientName: String?
    ): Response<IngredientSubstituteResource>

    @GET("mealplanner/{username}/week/{start-date}")
    suspend fun getWeekMealPlan(
        @Path("start-date") date: String,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<WeekMealPlanResource>

    @POST("mealplanner/{username}/items")
    suspend fun addToMealPlan(
        @Body addToMeal: AddMealResource,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<ResultAddToMealPlanResource>

    @POST("users/connect")
    suspend fun connectUser(
        @Body userData: UserInformationResource
    ): Response<ConnectUserResource>

    @GET("recipes/{id}/analyzedInstructions")
    suspend fun getAnalyzedInstructions(
        @Path("id") id: Int,
        @Query("stepBreakdown") stepBreakdown: Boolean? = false,
        ): Response<List<AnalyzedInstructionResource>>
    @GET ("recipes/findByNutrients")
    suspend fun getRecipesByRangeCalories(
    @Query("minCalories") minCalories: Double = 50.0,
    @Query("maxCalories") maxCalories: Double = 5000.0
    ): Response<List<RecipesByRangeOfCaloriesResource>>
}