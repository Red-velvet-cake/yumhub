package com.red_velvet.yumhub.local

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.local.daos.ChatBotDao
import com.red_velvet.yumhub.local.daos.MealsDao
import com.red_velvet.yumhub.local.daos.RecipeDao
import com.red_velvet.yumhub.local.entities.CategoryLocalDto
import com.red_velvet.yumhub.local.entities.FavoriteRecipeDto
import com.red_velvet.yumhub.local.entities.HealthyRecipeLocalDto
import com.red_velvet.yumhub.local.entities.HistoryItemLocalDto
import com.red_velvet.yumhub.local.entities.MealPlanLocalDto
import com.red_velvet.yumhub.local.entities.PopularRecipeLocalDto
import com.red_velvet.yumhub.local.entities.QuickAnswerLocalDto
import com.red_velvet.yumhub.local.entities.QuickRecipeLocalDto
import com.red_velvet.yumhub.local.entities.SliderItemLocalDto
import com.red_velvet.yumhub.repositories.datasources.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val recipeDao: RecipeDao,
    private val mealsDao: MealsDao,
    private val chatBotDao: ChatBotDao
) : LocalDataSource {

    override suspend fun insertChatBotMessage(quickAnswerLocalDto: QuickAnswerLocalDto) {
        chatBotDao.insertChatBotMessage(quickAnswerLocalDto)
    }

override fun getChatBotMessages(): Flow<List<QuickAnswerLocalDto>> {
        return chatBotDao.getChatBotMessages()
    }

    override fun getWeekMealsPlan(
        fromTimestamp: Long,
        toTimestamp: Long
    ): Flow<List<MealPlanLocalDto>> {
        return mealsDao.getWeekMealsPlan(fromTimestamp, toTimestamp)
    }

    override suspend fun insertWeekPlanMeal(mealPlanLocalDto: List<MealPlanLocalDto>) {
        mealsDao.insertWeekPlanMeal(mealPlanLocalDto)
    }

    override fun getHealthyRecipes(): Flow<List<HealthyRecipeLocalDto>> {
        return recipeDao.getHealthyRecipes()
    }

    override suspend fun insertHealthyRecipes(healthyRecipes: List<HealthyRecipeLocalDto>) {
        recipeDao.insertHealthyRecipes(healthyRecipes)
    }

    override fun getPopularRecipes(): Flow<List<PopularRecipeLocalDto>> {
        return recipeDao.getPopularRecipes()
    }

    override suspend fun insertPopularRecipes(popularRecipes: List<PopularRecipeLocalDto>) {
        recipeDao.insertPopularRecipes(popularRecipes)
    }

    override fun getQuickRecipes(): Flow<List<QuickRecipeLocalDto>> {
        return recipeDao.getQuickRecipes()
    }

    override suspend fun insertQuickRecipes(quickRecipes: List<QuickRecipeLocalDto>) {
        recipeDao.insertQuickRecipes(quickRecipes)
    }

    override suspend fun getHomeSliderImagesList(): List<SliderItemLocalDto> {
        return listOf(
            SliderItemLocalDto(R.drawable.slide_1),
            SliderItemLocalDto(R.drawable.slide_2),
            SliderItemLocalDto(R.drawable.slide_3)
        )
    }

    override suspend fun getFavoriteRecipes(): List<FavoriteRecipeDto> {
        return recipeDao.getFavoriteRecipes()
    }

    override suspend fun saveFavoriteRecipe(recipe: FavoriteRecipeDto) {
        recipeDao.saveFavoriteRecipe(recipe)
    }

    override suspend fun deleteFavoriteRecipe(recipe: FavoriteRecipeDto) {
        recipeDao.deleteFavoriteRecipe(recipe)
    }

    override suspend fun clearFavoriteRecipes() {
        recipeDao.clearFavoriteRecipes()
    }

    override fun getHistoryMeals(): Flow<List<HistoryItemLocalDto>> {
        return mealsDao.getHistoryMeals()
    }

    override suspend fun insertHistoryItem(historyItemLocalDto: List<HistoryItemLocalDto>) {
        mealsDao.insertHistoryMeal(historyItemLocalDto)
    }

    override suspend fun deleteHistoryItem(mealId: Int) {
        mealsDao.deleteHistoryMeal(mealId)
    }

    private val mealTypes = listOf(
        "Main course",
        "Side dish",
        "Dessert",
        "Appetizer",
        "Salad",
        "Bread",
        "Breakfast",
        "Soup",
        "Beverage",
        "Sauce",
        "Marinade",
        "Fingerfood",
        "Snack",
        "Drink"
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

    private val list = mealTypes.zip(mealImages).map { CategoryLocalDto(it.first, it.second) }

    override suspend fun getCategories(): List<CategoryLocalDto> {
        return list
    }
}
