package com.red_velvet.yumhub.ui.add_to_meal_plan

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.usecases.AddToMealPlanUseCase
import com.red_velvet.yumhub.domain.usecases.ConvertDateToTimestampUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddToMealPlanViewModel @Inject constructor(
    private val addToMealPlanUseCase: AddToMealPlanUseCase,
    private val convertDateToTimestampUseCase: ConvertDateToTimestampUseCase
) : BaseViewModel<AddToMealPlanUiState>(AddToMealPlanUiState()), OnChooseMealTimeListener {

    @RequiresApi(Build.VERSION_CODES.O)
    fun onUpdateSelectedDate(year: Int, month: Int, dayOfMonth: Int) {
        val timeStamp = convertDateToTimestampUseCase(year, month, dayOfMonth)
        _state.update { it.copy(addMealUiState = it.addMealUiState.copy(timeStamp = timeStamp)) }
    }

    override fun onChooseMealPlanTime(slot: Int) {
        _state.update { it.copy(addMealUiState = it.addMealUiState.copy(slot = slot)) }
    }

    fun onAddRecipeToMealPlan() {
        viewModelScope.launch {
            _state.collect {
                val mealPlanEntity = it.addMealUiState.toEntity()
                addToMealPlanUseCase(mealPlanEntity)
            }
        }
    }

}
