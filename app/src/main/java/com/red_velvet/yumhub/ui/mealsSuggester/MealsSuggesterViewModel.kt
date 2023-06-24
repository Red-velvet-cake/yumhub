package com.red_velvet.yumhub.ui.mealsSuggester

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.CalculateNeededCaloriesUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsSuggesterViewModel @Inject constructor(
    private val calculateNeededCaloriesUseCase: CalculateNeededCaloriesUseCase,
) : BaseViewModel<MealsSuggesterUiState>(MealsSuggesterUiState()) {
    private val _effect = MutableSharedFlow<MealsSuggesterUiEffect>()
    val effect = _effect.asSharedFlow()



      fun updateGender(gender: String)
    {
        _state.update { it.copy(gender = gender) }
        viewModelScope.launch { _effect.emit(MealsSuggesterUiEffect.clickOnGenderSelector(gender)) }
        Log.i("jalalCheff",_state.value.toString())
    }
     fun updateActivityLevel(activityLevel: String)
    {
        _state.update { it.copy(activityLevel = activityLevel) }

        Log.i("jalalCheff",_state.value.toString())
    }

    }