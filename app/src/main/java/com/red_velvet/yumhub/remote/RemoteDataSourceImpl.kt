package com.red_velvet.yumhub.remote

import android.util.Log
import com.red_velvet.yumhub.domain.models.exceptions.NetworkException
import com.red_velvet.yumhub.remote.resources.AnalyzedInstructionResource
import com.red_velvet.yumhub.remote.resources.ExtendedIngredientResource
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
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import retrofit2.Response
import java.io.IOException
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
    ): RecipeSearchPaginationResource {
        return tryToExecute {
            foodService.searchRecipe(
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
    }

    override suspend fun getRecipesByMealType(
        type: String?,
        addRecipeInformation: Boolean?,
        sort: String?
    ): RecipeSearchPaginationResource {
        return tryToExecute { foodService.getRecipesByMealType(type, addRecipeInformation, sort) }
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): RecipeInformationResource {
        return tryToExecute { foodService.getRecipeInformation(id, includeNutrition) }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): SimilarRecipesResource {
        return tryToExecute { foodService.getSimilarRecipes(id, number) }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): RandomRecipesResource {
        return tryToExecute { foodService.getRandomRecipes(tags, number) }
    }

    override suspend fun guessNutrition(title: String): GuessNutritionResource {
        return tryToExecute { foodService.guessNutrition(title) }
    }

    override suspend fun getQuickAnswer(question: String): QuickAnswerResource {
        return tryToExecute { foodService.getQuickAnswer(question) }
    }

    override suspend fun searchIngredients(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): IngredientSearchResource {
        return tryToExecute { foodService.searchIngredients(query, sort, intolerances, number) }
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): IngredientInformationResource {
        return tryToExecute { foodService.getIngredientInformation(id, amount, unit) }
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String?): IngredientSubstituteResource {
        return tryToExecute { foodService.getSubstitutesIngredient(ingredientName) }
    }

    override suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): WeekMealPlanResource {
        return tryToExecute { foodService.getWeekMealPlan(date, username, hash) }
    }

    override suspend fun addToMealPlan(
        addToMeal: AddMealResource,
        username: String,
        hash: String
    ): ResultAddToMealPlanResource {
        return tryToExecute { foodService.addToMealPlan(addToMeal, username, hash) }
    }

    override suspend fun connectUser(userData: UserInformationResource): ConnectUserResource {
        return tryToExecute { foodService.connectUser(userData) }
    }

    override suspend fun getAnalyzedInstructions(
        id: Int,
        stepBreakdown: Boolean?,
    ): List<AnalyzedInstructionResource> {
        return tryToExecute { foodService.getAnalyzedInstructions(id, stepBreakdown) }
    }

    override suspend fun getExtendedIngredients(
        id: Int,
        includeNutrition: Boolean
    ): List<ExtendedIngredientResource> {
        return tryToExecute { foodService.getExtendedIngredients(id, includeNutrition) }
    }

    private suspend fun <T> tryToExecute(func: suspend () -> Response<T>): T {
        val response = func()
        Log.d("TAG", "tryToExecute: ${response.code()}")
        if (response.isSuccessful) {
            return response.body() ?: throw NetworkException.NotFoundException
        }
        throw when (response.code()) {
            404 -> NetworkException.NotFoundException
            402 -> NetworkException.ApiKeyExpiredException
            401 -> NetworkException.UnAuthorizedException
            else -> IOException()
        }
    }
}