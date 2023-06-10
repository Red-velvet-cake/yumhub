package com.red_velvet.yumhub.data.local

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.data.local.entities.CategoryLocalModel
import com.red_velvet.yumhub.data.repositories.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor() : LocalDataSource {

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

    private val list = mealTypes.zip(mealImages).map { CategoryLocalModel(it.first, it.second) }

    override suspend fun getCategories(): List<CategoryLocalModel> {
        return list
    }
}
