package com.red_velvet.yumhub.ui.mealPlan

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.usecases.GetWeekMealsPlanUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor(
    private val getWeeklyPlannedMeals: GetWeekMealsPlanUseCase
) :
    BaseViewModel<MealPlanUiState, MealPlanUiEffect>(MealPlanUiState()),
    MealPlanInteractionListener {



    init {
        getWeekMealsPlan()
        initSelectedDay()
    }

    private fun initSelectedDay() {
        _state.update { it.copy(selectedDay = it.daysPlannedMeals.first().date) }
    }


    private fun getWeekMealsPlan() {
        tryToExecute(
            { getWeeklyPlannedMeals("2023-6-28") },
            ::onGetWeekMealsPlanSuccess,
            ::onError
        )
    }

    private fun onGetWeekMealsPlanSuccess(days: List<DayPlannedMealsEntity>) {
        _state.update {
            it.copy(
                daysPlannedMeals = days.toDayPlannedMealsUiState(),
                breakfastMeals = days.filter { it.timestamp == state.value.selectedDay }
                    .flatMap { it.meals }.filter { it.slot == 1 }.toMealUiState(),
                lunchMeals = days.filter { it.timestamp == state.value.selectedDay }
                    .flatMap { it.meals }.filter { it.slot == 2 }.toMealUiState(),
                dinnerMeals = days.filter { it.timestamp == state.value.selectedDay }
                    .flatMap { it.meals }.filter { it.slot == 3 }.toMealUiState(),
            )
        }
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(error = error) }
    }

    override fun onCalendarDaySelected(timestamp: Int) {
        _state.update { it.copy(selectedDay = timestamp) }
    }

    override fun onMealClicked(meal: MealPlanUiState.MealUiState) {
        viewModelScope.launch { _effect.emit(MealPlanUiEffect.ShowMealDetails(meal.id)) }
    }

}