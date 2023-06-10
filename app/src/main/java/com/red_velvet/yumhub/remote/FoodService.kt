package com.red_velvet.yumhub.remote

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
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.RecipeSearchPagination>

    @GET("recipes/complexSearch")
    suspend fun getRecipesByMealType(
        @Query("type") type: String? = "",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.RecipeSearchPagination>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean? = false,
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.RecipeInformationDto>

    @GET("recipes/{id}/similar")
    suspend fun getSimilarRecipes(
        @Path("id") id: Int,
        @Query("number") number: Int? = 3,
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.SimilarRecipesDto>

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("tags") tags: String? = "",
        @Query("number") number: Int? = 10,
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.RandomRecipesDto>

    @GET("recipes/guessNutrition")
    suspend fun guessNutrition(
        @Query("title") title: String = "",
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.GuessNutritionDto>

    @GET("recipes/quickAnswer")
    suspend fun getQuickAnswer(
        @Query("q") question: String = "",
    ): Response<com.red_velvet.yumhub.remote.dtos.recipe.QuickAnswerDto>

    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("sort") sort: String? = "",
        @Query("intolerances") intolerances: String? = "",
        @Query("number") number: Int? = 10,
    ): Response<com.red_velvet.yumhub.remote.dtos.ingredient.IngredientSearchDto>

    @GET("food/ingredients/{id}/information")
    suspend fun getIngredientInformation(
        @Path("id") id: Int,
        @Query("amount") amount: Int? = null,
        @Query("unit") unit: String? = null,
    ): Response<com.red_velvet.yumhub.remote.dtos.ingredient.IngredientInformationDto>

    @GET("food/ingredients/substitutes")
    suspend fun getSubstitutesIngredient(
        @Query("ingredientName") ingredientName: String?,
    ): Response<com.red_velvet.yumhub.remote.dtos.ingredient.IngredientSubstituteDto>

    @GET("mealplanner/{username}/week/{start-date}")
    suspend fun getWeekMealPlan(
        @Path("start-date") date: String,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<com.red_velvet.yumhub.remote.dtos.meal_plan.WeekMealPlanDto>

    @POST("mealplanner/{username}/items")
    suspend fun addToMealPlan(
        @Body addToMeal: com.red_velvet.yumhub.remote.dtos.meal_plan.AddMealDto,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<com.red_velvet.yumhub.remote.dtos.meal_plan.ResultAddToMealPlanDto>

    @POST("users/connect")
    suspend fun connectUser(
        @Body userData: com.red_velvet.yumhub.remote.dtos.auth.UserInformationDto
    ): Response<com.red_velvet.yumhub.remote.dtos.auth.ConnectUserDto>

}
