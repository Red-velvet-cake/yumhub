package com.red_velvet.remote

import com.red_velvet.domain.models.exceptions.NetworkException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val foodService: FoodService
) : com.red_velvet.repository.datasources.RemoteDataSource {

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
    ): com.red_velvet.repository.resources.recipe.RecipeSearchPaginationResource {
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
        addRecipeInformation: Boolean?
    ): com.red_velvet.repository.resources.recipe.RecipeSearchPaginationResource {
        return tryToExecute { foodService.getRecipesByMealType(type, addRecipeInformation) }
    }

    override suspend fun getRecipeInformation(
        id: Int,
        includeNutrition: Boolean?
    ): com.red_velvet.repository.resources.recipe.RecipeInformationResource {
        return tryToExecute { foodService.getRecipeInformation(id, includeNutrition) }
    }

    override suspend fun getSimilarRecipes(id: Int, number: Int?): com.red_velvet.repository.resources.recipe.SimilarRecipesResource {
        return tryToExecute { foodService.getSimilarRecipes(id, number) }
    }

    override suspend fun getRandomRecipes(tags: String?, number: Int?): com.red_velvet.repository.resources.recipe.RandomRecipesResource {
        return tryToExecute { foodService.getRandomRecipes(tags, number) }
    }

    override suspend fun guessNutrition(title: String): com.red_velvet.repository.resources.recipe.GuessNutritionResource {
        return tryToExecute { foodService.guessNutrition(title) }
    }

    override suspend fun getQuickAnswer(question: String): com.red_velvet.repository.resources.recipe.QuickAnswerResource {
        return tryToExecute { foodService.getQuickAnswer(question) }
    }

    override suspend fun searchIngredients(
        query: String,
        sort: String?,
        intolerances: String?,
        number: Int?
    ): com.red_velvet.repository.resources.ingredient.IngredientSearchResource {
        return tryToExecute { foodService.searchIngredients(query, sort, intolerances, number) }
    }

    override suspend fun getIngredientInformation(
        id: Int,
        amount: Int?,
        unit: String?
    ): com.red_velvet.repository.resources.ingredient.IngredientInformationResource {
        return tryToExecute { foodService.getIngredientInformation(id, amount, unit) }
    }

    override suspend fun getSubstitutesIngredient(ingredientName: String?): com.red_velvet.repository.resources.ingredient.IngredientSubstituteResource {
        return tryToExecute { foodService.getSubstitutesIngredient(ingredientName) }
    }

    override suspend fun getWeekMealPlan(
        date: String,
        username: String,
        hash: String
    ): com.red_velvet.repository.resources.meal_plan.WeekMealPlanResource {
        return tryToExecute { foodService.getWeekMealPlan(date, username, hash) }
    }

    override suspend fun addToMealPlan(
        addToMeal: com.red_velvet.repository.resources.meal_plan.AddMealResource,
        username: String,
        hash: String
    ): com.red_velvet.repository.resources.meal_plan.ResultAddToMealPlanResource {
        return tryToExecute { foodService.addToMealPlan(addToMeal, username, hash) }
    }

    override suspend fun connectUser(userData: com.red_velvet.repository.resources.auth.UserInformationResource): com.red_velvet.repository.resources.auth.ConnectUserResource {
        return tryToExecute { foodService.connectUser(userData) }
    }

    override suspend fun getAnalyzedInstructions(
        id: Int,
        stepBreakdown: Boolean?,
    ): List<com.red_velvet.repository.resources.AnalyzedInstructionResource> {
        return tryToExecute {foodService.getAnalyzedInstructions(id,stepBreakdown)}
    }

    private suspend fun <T> tryToExecute(func: suspend () -> Response<T>): T {
        val response = func()
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