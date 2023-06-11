package com.red_velvet.yumhub.remote

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
import com.red_velvet.yumhub.repositories.RemoteDataSource
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
    ): RecipeSearchPagination {
        val response = foodService.searchRecipe(
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
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRecipesByMealType(
        type: String?,
        addRecipeInformation: Boolean?
    ): RecipeSearchPagination {
        val response = foodService.getRecipesByMealType(type, addRecipeInformation)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationDto {
        val response = foodService.getRecipeInformation(id, includeNutrition)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): SimilarRecipesDto {
        val response = foodService.getSimilarRecipes(id, number)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): RandomRecipesDto {
        val response = foodService.getRandomRecipes(tags, number)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun guessNutrition(title: String): GuessNutritionDto {
        val response = foodService.guessNutrition(title)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswerDto {
        val response = foodService.getQuickAnswer(question)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun searchIngredients(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): IngredientSearchDto {
        val response = foodService.searchIngredients(query, sort, intolerances, number)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformationDto {
        val response = foodService.getIngredientInformation(id, amount, unit)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String?): IngredientSubstituteDto {
        val response = foodService.getSubstitutesIngredient(ingredientName)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): WeekMealPlanDto {
        val response = foodService.getWeekMealPlan(date, username, hash)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun addToMealPlan(
        addToMeal: AddMealDto,
        username: String,
        hash: String
    ): ResultAddToMealPlanDto {
        val response = foodService.addToMealPlan(addToMeal, username, hash)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }

    override suspend fun connectUser(userData: UserInformationDto): ConnectUserDto {
        val response = foodService.connectUser(userData)
        if(response.isSuccessful){
            return response.body()!!
        } else {
            throw Exception(response.message())
        }
    }
}