package com.red_velvet.yumhub.domain.usecases

import android.util.Log
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.models.recipes.RecipeEntity
import com.red_velvet.yumhub.domain.repositories.MealRepository
import com.red_velvet.yumhub.domain.repositories.RecipesRepository
import javax.inject.Inject

class CalculateNeededCaloriesUseCase @Inject constructor(
    private val recipesRepository: RecipesRepository
) {
    suspend fun calculateNeededCalories(foodSystemEntity: FoodSystemEntity):List<RecipeEntity> {
        val BMR = calculateBMR(
            gender = foodSystemEntity.gender,
            age = foodSystemEntity.age,
            weight = foodSystemEntity.weight,
            height = foodSystemEntity.height
        )
        val activityLevel = calculateActivityLevel(BMR,foodSystemEntity.activityLevel)
        val goalCalories = calculateGoalCalories(activityLevel , foodSystemEntity.goal)
        Log.i("jalalCheff","goal is ${goalCalories.maxCalories} and ${goalCalories.minCalories}")
        return recipesRepository.getMealByCalories(
            minCalories = goalCalories.minCalories,
            maxCalories = goalCalories.maxCalories
        )
    }

    private fun calculateGoalCalories(calculateActivityLevel: Double, goal: String): RecipeCalories {
        Log.i("jalal","goal of actvivty is $calculateActivityLevel")
        return when(goal) {
            "lose" ->{
                val maxCalories = calculateActivityLevel - 500
                val minCalories = calculateActivityLevel - 1000
                RecipeCalories(minCalories = 0.0 , maxCalories = minCalories)
            }
            "gain"->{
                val maxCalories = calculateActivityLevel + 500
                val minCalories = calculateActivityLevel + 250
                RecipeCalories(minCalories = 0.0 , maxCalories = maxCalories)
            }

            else -> {
                RecipeCalories(minCalories = calculateActivityLevel , maxCalories = calculateActivityLevel)
            }
        }
    }

    private fun calculateActivityLevel(calculateBMR: Double, activityLevel: Int): Double {
        return when(activityLevel)
        {
            SEDENTARY->calculateBMR * 1.2
            LIGHTLY->calculateBMR * 1.375
            MODERATELY->calculateBMR * 1.55
            VERY_ACTIVE->calculateBMR * 1.725
            else -> calculateBMR * 1.9
        }
    }

    private fun calculateBMR(gender: String, weight: Int, height: Int, age: Int): Double {
        return if (gender == "male") {
            val BMR = 66 + (6.23 * weight ) + (12.7 * height) - (6.8 * age)
            BMR
        } else {
            val BMR = 655 + (4.35 * weight ) + (4.7 * height) - (4.7 * age)
            BMR
        }
    }
    inner class RecipeCalories(
        val minCalories : Double,
        val maxCalories : Double,
            )
    companion object{
        const val SEDENTARY = 1
        const val LIGHTLY = 2
        const val MODERATELY = 3
        const val VERY_ACTIVE = 4
        const val EXTRA_ACTIVE = 5
    }
}