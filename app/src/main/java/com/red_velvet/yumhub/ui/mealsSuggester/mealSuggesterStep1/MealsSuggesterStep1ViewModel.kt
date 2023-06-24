package com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep1

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.mealsSuggester.mealSuggesterStep2.MealsSuggesterStep2UiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterStep1ViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterStep1UiState>(MealsSuggesterStep1UiState()) {
    private val _effect = MutableSharedFlow<MealsSuggesterStep1UiEffect>()
    val effect = _effect.asSharedFlow()



      fun updateGender(gender: String)
    {
        _state.update { it.copy(gender = gender) }
        viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.ClickOnGenderSelector(gender)) }
    }
     fun updateActivityLevel(activityLevel: String)
    {
        _state.update { it.copy(activityLevel = activityLevel) }
        viewModelScope.launch { _effect.emit(MealsSuggesterStep1UiEffect.ClickOnActivityLevelSelector(activityLevel)) }
    }

    }