package com.red_velvet.yumhub.ui.mealPlan

import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.usecases.GetWeekMealsPlanUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MealPlanViewModel @Inject constructor(
    private val getWeeklyPlannedMeals: GetWeekMealsPlanUseCase
) :
    BaseViewModel<MealPlanUiState, MealPlanUiEffect>(MealPlanUiState()),
    MealPlanInteractionListener {


    init {
        getWeekMealsPlan(getFormattedDate(state.value.selectedTimestamp))
    }

    private fun getWeekMealsPlan(date: String) {
        tryToExecute(
            { getWeeklyPlannedMeals(date) },
            ::onGetWeekMealsPlanSuccess,
            ::onError
        )
    }

    private fun onGetWeekMealsPlanSuccess(days: List<DayPlannedMealsEntity>) {
        updateSelectedTimestamp(days.first().timestamp)
        updatePlannedMeals(days)
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(error = error) }
    }

    private fun updateSelectedTimestamp(timestamp: Int) {
        _state.update { it.copy(selectedTimestamp = timestamp) }
    }

    private fun updatePlannedMeals(days: List<DayPlannedMealsEntity>) {
        _state.update {
            it.copy(
                daysPlannedMeals = days.toDayPlannedMealsUiState(),
                breakfastMeals = days.toBreakfastMealsUiState(state.value.selectedTimestamp),
                lunchMeals = days.toLunchMealsUiState(state.value.selectedTimestamp),
                dinnerMeals = days.toDinnerMealsUiState(state.value.selectedTimestamp)
            )
        }
    }

    override fun onDaySelected(timestamp: Int) {
        updateSelectedTimestamp(timestamp)
        showSelectedDayMeals(timestamp)
    }

    override fun onPageChanged(position: Int) {
        _state.update { it.copy(pagePosition = position) }
    }

    fun onDateSelected(date: String) {
        updateSelectedTimestamp(getTimestamp(date))
        getWeekMealsPlan(date)
    }

    override fun onDatePickerClicked() {
        viewModelScope.launch { _effect.emit(MealPlanUiEffect.ShowDatePicker) }
    }

    private fun showSelectedDayMeals(timestamp: Int) {
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
    }

    private fun getFormattedDate(timestamp: Int): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val netDate = Date(timestamp.toLong() * 1000)
        return sdf.format(netDate)
    }

    private fun getTimestamp(date: String): Int {
        val sdf = SimpleDateFormat("yyyy-M-d-H-m-s")
        val netDate = sdf.parse(date)
        return (netDate.time / 1000).toInt()
    }

}