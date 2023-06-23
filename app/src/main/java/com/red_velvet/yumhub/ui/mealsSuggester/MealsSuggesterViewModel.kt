package com.red_velvet.yumhub.ui.mealsSuggester

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.FoodSystemEntity
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterUiState>(MealsSuggesterUiState()) {
    private val _effect = MutableSharedFlow<MealsSuggesterUiEffect>()
    val effect = _effect.asSharedFlow()

    init {
        viewModelScope.launch {
           val recepies = calculateNeededCaloriesUseCase.calculateNeededCalories(
                FoodSystemEntity(
                    age = 10,
                    gender = "male",
                    height = 180,
                    weight = 80,
                    goal = "gain",
                    activityLevel = 1,
                )
            )
            Log.i("jalal", "hoooo ${recepies}")
        }
    }

    suspend fun caloriesDetails(age: Int, gender: String, height: Int, weight: Int, activityLevel: Int, goal: String) {
        calculateNeededCaloriesUseCase.calculateNeededCalories(
            FoodSystemEntity(
                age = age,
                gender = gender,
                height = height,
                weight = weight,
                goal = goal,
                activityLevel = activityLevel,
            )

        )
    }
}