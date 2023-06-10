package com.red_velvet.yumhub.remote

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
import com.red_velvet.yumhub.repositories.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val foodService: FoodService
) : RemoteDataSource {

    override suspend fun searchRecipe(
        query: String?,
        cuisine: String?,
        intolerances: String?,
        diet: String?,
        excludeCuisine: String?,
        includeIngredients: String?,
        excludeIngredients: String?,
        sort: String?,
        sortDirection: String?,
        addRecipeInformation: Boolean?
    ): Response<RecipeSearchPagination> {
        return foodService.searchRecipe(
            query,
            cuisine,
            intolerances,
            diet,
            excludeCuisine,
            includeIngredients,
            excludeIngredients,
            sort,
            sortDirection,
            addRecipeInformation
        )
    }

    override suspend fun getRecipesByMealType(
        type: String?,
        addRecipeInformation: Boolean?
    ): Response<RecipeSearchPagination> {
        return foodService.getRecipesByMealType(type, addRecipeInformation)
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): Response<RecipeInformationDto> {
        return foodService.getRecipeInformation(id, includeNutrition)
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): Response<SimilarRecipesDto> {
        return foodService.getSimilarRecipes(id, number)
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): Response<RandomRecipesDto> {
        return foodService.getRandomRecipes(tags, number)
    }

    override suspend fun guessNutrition(title: String): Response<GuessNutritionDto> {
        return foodService.guessNutrition(title)
    }

    override suspend fun getQuickAnswer(question: String): Response<QuickAnswerDto> {
        return foodService.getQuickAnswer(question)
    }

    override suspend fun searchIngredients(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): Response<IngredientSearchDto> {
        return foodService.searchIngredients(query, sort, intolerances, number)
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): Response<IngredientInformationDto> {
        return foodService.getIngredientInformation(id, amount, unit)
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String?): Response<IngredientSubstituteDto> {
        return foodService.getSubstitutesIngredient(ingredientName)
    }

    override suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): Response<WeekMealPlanDto> {
        return foodService.getWeekMealPlan(date, username, hash)
    }

    override suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): Response<ResultAddToMealPlanDto> {
        return foodService.addToMealPlan(addToMeal, username, hash)
    }

    override suspend fun connectUser(userData: UserInformationDto): Response<ConnectUserDto> {
        return foodService.connectUser(userData)
    }
}