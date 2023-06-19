package com.red_velvet.remote
import com.red_velvet.repository.resources.auth.UserInformationResource
import com.red_velvet.repository.resources.meal_plan.AddMealResource
import com.red_velvet.repository.resources.recipe.RecipeInformationResource
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
    ): Response<com.red_velvet.repository.resources.recipe.RecipeSearchPaginationResource>

    @GET("recipes/complexSearch")
    suspend fun getRecipesByMealType(
        @Query("type") type: String? = "",
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = true
    ): Response<com.red_velvet.repository.resources.recipe.RecipeSearchPaginationResource>

    @GET("recipes/{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean? = false
    ): Response<RecipeInformationResource>

    @GET("recipes/{id}/similar")
    suspend fun getSimilarRecipes(
        @Path("id") id: Int,
        @Query("number") number: Int? = 3
    ): Response<com.red_velvet.repository.resources.recipe.SimilarRecipesResource>

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("tags") tags: String? = "",
        @Query("number") number: Int? = 10
    ): Response<com.red_velvet.repository.resources.recipe.RandomRecipesResource>

    @GET("recipes/guessNutrition")
    suspend fun guessNutrition(
        @Query("title") title: String = ""
    ): Response<com.red_velvet.repository.resources.recipe.GuessNutritionResource>

    @GET("recipes/quickAnswer")
    suspend fun getQuickAnswer(
        @Query("q") question: String = ""
    ): Response<com.red_velvet.repository.resources.recipe.QuickAnswerResource>

    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("sort") sort: String? = "",
        @Query("intolerances") intolerances: String? = "",
        @Query("number") number: Int? = 10
    ): Response<com.red_velvet.repository.resources.ingredient.IngredientSearchResource>

    @GET("food/ingredients/{id}/information")
    suspend fun getIngredientInformation(
        @Path("id") id: Int,
        @Query("amount") amount: Int? = null,
        @Query("unit") unit: String? = null
    ): Response<com.red_velvet.repository.resources.ingredient.IngredientInformationResource>

    @GET("food/ingredients/substitutes")
    suspend fun getSubstitutesIngredient(
        @Query("ingredientName") ingredientName: String?
    ): Response<com.red_velvet.repository.resources.ingredient.IngredientSubstituteResource>

    @GET("mealplanner/{username}/week/{start-date}")
    suspend fun getWeekMealPlan(
        @Path("start-date") date: String,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<com.red_velvet.repository.resources.meal_plan.WeekMealPlanResource>

    @POST("mealplanner/{username}/items")
    suspend fun addToMealPlan(
        @Body addToMeal: AddMealResource,
        @Path("username") username: String,
        @Query("hash") hash: String
    ): Response<com.red_velvet.repository.resources.meal_plan.ResultAddToMealPlanResource>

    @POST("users/connect")
    suspend fun connectUser(
        @Body userData: UserInformationResource
    ): Response<com.red_velvet.repository.resources.auth.ConnectUserResource>

    @GET("recipes/{id}/analyzedInstructions")
    suspend fun getAnalyzedInstructions(
        @Path("id") id: Int,
        @Query("stepBreakdown") stepBreakdown: Boolean? = false,
        ): Response<List<com.red_velvet.repository.resources.AnalyzedInstructionResource>>
}
