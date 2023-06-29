package com.red_velvet.yumhub.ui.mealPlan

import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.usecases.GetWeekMealsPlanUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor(
    private val getWeeklyPlannedMeals: GetWeekMealsPlanUseCase
) :
    BaseViewModel<MealPlanUiState, MealPlanUiEffect>(MealPlanUiState()),
    MealPlanInteractionListener {



    init {
        getWeekMealsPlan()
    }

    private fun updateSelectedDay(timestamp: Int) {
        _state.update { it.copy(selectedDay = timestamp) }
    }


    private fun getWeekMealsPlan() {
        tryToExecute(
            { getWeeklyPlannedMeals("2023-6-29") },
            ::onGetWeekMealsPlanSuccess,
            ::onError
        )
    }

    private fun onGetWeekMealsPlanSuccess(days: List<DayPlannedMealsEntity>) {
        updateSelectedDay(days.first().timestamp)
        _state.update {
            it.copy(
                daysPlannedMeals = days.toDayPlannedMealsUiState(),
                breakfastMeals = days.filter { day -> day.timestamp == state.value.selectedDay }
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

    private fun showSelectedDayMeals(timestamp: Int) {
        state.value.daysPlannedMeals.filter { it.date == timestamp }.apply {
            _state.update {
                it.copy(
                    breakfastMeals = this.flatMap { it.meals }.filter { it.slot == 1 },
                    lunchMeals = this.flatMap { it.meals }.filter { it.slot == 2 },
                    dinnerMeals = this.flatMap { it.meals }.filter { it.slot == 3 },
                )
            }
        }
    }


    override fun onDaySelected(timestamp: Int) {
        updateSelectedDay(timestamp)
        showSelectedDayMeals(timestamp)
    }

    override fun onPageChanged(position: Int) {
        _state.update { it.copy(pagePosition = position) }
    }

}