package com.red_velvet.yumhub.ui.mealPlan

import android.util.Log
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
        Log.d("SADEQMHANA", "updateSelectedDay: ${state.value.selectedDay}")
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

        Log.d("SADEQMHANA", "Old days: ${state.value.daysPlannedMeals}")
        Log.d("SADEQMHANA", "Old breakfast: ${state.value.breakfastMeals}")
        Log.d("SADEQMHANA", "Old lunch: ${state.value.lunchMeals}")
        Log.d("SADEQMHANA", "Old dinner: ${state.value.dinnerMeals}")
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(error = error) }
    }

    private fun showSelectedDayMeals(timestamp: Int) {
//        state.value.daysPlannedMeals.filter { it.date == timestamp }.apply {
//            Log.d("SADEQMHANA", "Updated Meals: $this")
//            _state.update {
//                it.copy(
//                    breakfastMeals = this.flatMap { it.meals }.filter { it.slot == 1 },
//                    lunchMeals = this.flatMap { it.meals }.filter { it.slot == 2 },
//                    dinnerMeals = this.flatMap { it.meals }.filter { it.slot == 3 },
//                )
//            }

        _state.update {
            it.copy(
                breakfastMeals = state.value.daysPlannedMeals.filter { it.date == timestamp }
                    .flatMap { it.meals }.filter { it.slot == 1 },

                lunchMeals = state.value.daysPlannedMeals.filter { it.date == timestamp }
                    .flatMap { it.meals }.filter { it.slot == 2 },

                dinnerMeals = state.value.daysPlannedMeals.filter { it.date == timestamp }
                    .flatMap { it.meals }.filter { it.slot == 3 },
            )
        }
        Log.d("SADEQMHANA", "new breakfast meals: ${state.value.breakfastMeals}")
        Log.d("SADEQMHANA", "new lunch meals: ${state.value.lunchMeals}")
        Log.d("SADEQMHANA", "new dinner meals: ${state.value.dinnerMeals}")
    }


    override fun onDaySelected(timestamp: Int) {
        Log.d("SADEQMHANA", "onDaySelected: $timestamp")
        updateSelectedDay(timestamp)
        showSelectedDayMeals(timestamp)
    }

    override fun onPageChanged(position: Int) {
        Log.d("SADEQMHANA", "onPageChanged: $position")
        _state.update { it.copy(pagePosition = position) }
    }

//    override fun onMealClicked(meal: MealPlanUiState.MealUiState) {
//        viewModelScope.launch { _effect.emit(MealPlanUiEffect.ShowMealDetails(meal.id)) }
//    }

}