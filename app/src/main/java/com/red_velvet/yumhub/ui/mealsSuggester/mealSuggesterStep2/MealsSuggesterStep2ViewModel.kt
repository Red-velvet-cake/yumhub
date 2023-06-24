package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1.MealsSuggesterStep2UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep2ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterStep2UiState>(MealsSuggesterStep2UiState()) {
    private val _effect = MutableSharedFlow<MealsSuggesterStep2UiEffect>()
    val effect = _effect.asSharedFlow()


    fun updateGoal(goal: String) {
        _state.update { it.copy(goal = goal) }
        viewModelScope.launch { _effect.emit(MealsSuggesterStep2UiEffect.ClickOnGoalSelector(goal)) }
    }

    fun updateTall(tall: String) {
        _state.update { it.copy(tall = tall.toInt()) }
    }

    fun updateAge(age: String) {
        _state.update { it.copy(age = age.toInt()) }
    }

    fun updateWeight(weight: String) {
        _state.update { it.copy(weight = weight.toInt()) }
    }
}