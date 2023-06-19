package com.red_velvet.local

import com.red_velvet.local.daos.MealsDao
import com.red_velvet.local.daos.RecipeDao
import com.red_velvet.repository.entities.CategoryLocalDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val recipeDao: RecipeDao,
    private val mealsDao: MealsDao
) : com.red_velvet.repository.datasources.LocalDataSource {
    override fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<com.red_velvet.repository.entities.MealPlanLocalDto>> {
        return mealsDao.getWeekMealsPlan(fromTimestamp, toTimestamp)
    }

    override suspend fun insertWeekPlanMeal(mealPlanLocalDto: List<com.red_velvet.repository.entities.MealPlanLocalDto>) {
        mealsDao.insertWeekPlanMeal(mealPlanLocalDto)
    }

    override fun getHealthyRecipes(): Flow<List<com.red_velvet.repository.entities.HealthyRecipeLocalDto>> {
        return recipeDao.getHealthyRecipes()
    }

    override suspend fun insertHealthyRecipes(healthyRecipes: List<com.red_velvet.repository.entities.HealthyRecipeLocalDto>) {
        recipeDao.insertHealthyRecipes(healthyRecipes)
    }

    override fun getPopularRecipes(): Flow<List<com.red_velvet.repository.entities.PopularRecipeLocalDto>> {
        return recipeDao.getPopularRecipes()
    }

    override suspend fun insertPopularRecipes(popularRecipes: List<com.red_velvet.repository.entities.PopularRecipeLocalDto>) {
        recipeDao.insertPopularRecipes(popularRecipes)
    }

    override fun getQuickRecipes(): Flow<List<com.red_velvet.repository.entities.QuickRecipeLocalDto>> {
        return recipeDao.getQuickRecipes()
    }

    override suspend fun insertQuickRecipes(quickRecipes: List<com.red_velvet.repository.entities.QuickRecipeLocalDto>) {
        recipeDao.insertQuickRecipes(quickRecipes)
    }


    private val mealTypes = listOf(
        "main course",
        "side dish",
        "dessert",
        "appetizer",
        "salad",
        "bread",
        "breakfast",
        "soup",
        "beverage",
        "sauce",
        "marinade",
        "fingerfood",
        "snack",
        "drink"
    )

    private val mealImages = listOf(
        R.drawable.main_course,
        R.drawable.side_dish,
        R.drawable.dessert,
        R.drawable.appteizer,
        R.drawable.salad,
        R.drawable.bread,
        R.drawable.breakfast,
        R.drawable.soup,
        R.drawable.beverage,
        R.drawable.sauce,
        R.drawable.marinade,
        R.drawable.finger_food,
        R.drawable.snacks,
        R.drawable.drinks
    )

    private val list = mealTypes.zip(mealImages).map {
        CategoryLocalDto(
            it.first,
            it.second
        )
    }

    override suspend fun getCategories(): List<CategoryLocalDto> {
        return list
    }
}
