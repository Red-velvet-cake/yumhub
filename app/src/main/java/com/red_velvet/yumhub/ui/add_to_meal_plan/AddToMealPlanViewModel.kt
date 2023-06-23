package com.red_velvet.yumhub.ui.add_to_meal_plan

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.AddToMealPlanUseCase
import com.red_velvet.yumhub.domain.usecases.ConvertDateToTimestampUseCase
import com.red_velvet.yumhub.domain.usecases.ValidateAddToMealPlanUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddToMealPlanViewModel @Inject constructor(
    private val addToMealPlanUseCase: AddToMealPlanUseCase,
    private val validateAddToMealPlanUseCase: ValidateAddToMealPlanUseCase,
    private val convertDateToTimestampUseCase: ConvertDateToTimestampUseCase,
    stateHandle: SavedStateHandle
) : BaseViewModel<AddToMealPlanUiState, AddToMealPlanUiEffect>(AddToMealPlanUiState()),
    OnChooseMealTimeListener {

    private val mealId = 640338
//    AddToMealPlanFragmentArgs.fromSavedStateHandle(stateHandle)

    init {
        _state.update { it.copy(addMealUiState = it.addMealUiState.copy(id = mealId)) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onUpdateSelectedDate(year: Int, month: Int, dayOfMonth: Int) {
        if (month > 0) {
            val timeStamp = convertDateToTimestampUseCase(year, month, dayOfMonth)
            _state.update { it.copy(addMealUiState = it.addMealUiState.copy(timeStamp = timeStamp)) }
        } else {
            onInvalidInput()
        }
    }

    override fun onChooseMealPlanTime(slot: Int) {
        _state.update { it.copy(addMealUiState = it.addMealUiState.copy(slot = slot)) }
    }

    fun onAddRecipeToMealPlan() {
        viewModelScope.launch {
            val timeStamp = _state.value.addMealUiState.timeStamp
            if (validateAddToMealPlanUseCase(timeStamp)) {
                val mealPlanEntity = _state.value.addMealUiState.toEntity()
                addToMealPlanUseCase(mealPlanEntity)
            } else {
                onInvalidInput()
            }
        }
    }

    private fun onInvalidInput() {
        viewModelScope.launch {
            _effect.emit(AddToMealPlanUiEffect.InvalidInput)
        }
    }


}
