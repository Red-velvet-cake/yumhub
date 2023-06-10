package com.red_velvet.yumhub.data.remote

import com.red_velvet.yumhub.data.remote.dtos.auth.ConnectUserDto
import com.red_velvet.yumhub.data.remote.dtos.auth.UserInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientInformationDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchDto
import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSubstituteDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.AddMealDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.ResultAddToMealPlanDto
import com.red_velvet.yumhub.data.remote.dtos.meal_plan.WeekMealPlanDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.GuessNutritionDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.QuickAnswerDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RandomRecipesDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeSearchResource
import com.red_velvet.yumhub.data.remote.dtos.recipe.SimilarRecipesDto
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
        @Query("sortDirection") sortDirection: String? = "asc",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true,
    ): Response<RecipeSearchResource>

    @GET("recipes/complexSearch")
    suspend fun getRecipesByMealType(
        @Query("type") type: String? = "",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true
    ): Response<RecipeSearchResource>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean? = false,
    ): Response<RecipeInformationDto>

    @GET("recipes/{id}/similar")
    suspend fun getSimilarRecipes(
        @Path("id") id: Int,
        @Query("number") number: Int? = 3,
    ): Response<SimilarRecipesDto>

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("tags") tags: String? = "",
        @Query("number") number: Int? = 10,
    ): Response<RandomRecipesDto>

    @GET("recipes/guessNutrition")
    suspend fun guessNutrition(
        @Query("title") title: String = "",
    ): Response<GuessNutritionDto>

    @GET("recipes/quickAnswer")
    suspend fun getQuickAnswer(
        @Query("q") question: String = "",
    ): Response<QuickAnswerDto>

    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("sort") sort: String? = "",
        @Query("intolerances") intolerances: String? = "",
        @Query("number") number: Int? = 10,
    ): Response<IngredientSearchDto>

    @GET("food/ingredients/{id}/information")
    suspend fun getIngredientInformation(
        @Path("id") id: Int,
        @Query("amount") amount: Int? = null,
        @Query("unit") unit: String? = null,
    ): Response<IngredientInformationDto>

    @GET("food/ingredients/substitutes")
    suspend fun getSubstitutesIngredient(
        @Query("ingredientName") ingredientName: String?,
    ): Response<IngredientSubstituteDto>

    @GET("mealplanner/{username}/week/{start-date}")
    suspend fun getWeekMealPlan(
        @Path("start-date") date: String,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<WeekMealPlanDto>

    @POST("mealplanner/{username}/items")
    suspend fun addToMealPlan(
        @Body addToMeal: AddMealDto,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<ResultAddToMealPlanDto>

    @POST("users/connect")
    suspend fun connectUser(
        @Body userData: UserInformationDto
    ): Response<ConnectUserDto>

}
