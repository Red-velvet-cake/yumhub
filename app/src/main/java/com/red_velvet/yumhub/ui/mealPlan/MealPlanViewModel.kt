package com.red_velvet.yumhub.ui.mealPlan

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.DayPlannedMealsEntity
import com.red_velvet.yumhub.domain.usecases.GetWeekMealsPlanUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
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
        val date = getFormattedDate(state.value.selectedDay ?: getCurrentTimestamp())
        tryToExecute(
            { getWeeklyPlannedMeals(date) },
            ::onGetWeekMealsPlanSuccess,
            ::onError
        )
    }

    private fun onGetWeekMealsPlanSuccess(days: List<DayPlannedMealsEntity>) {
        _state.update {
            it.copy(
                daysPlannedMeals = days.toDayPlannedMealsUiState(),
                breakfastMeals = days.toBreakfastMealsUiState(state.value.selectedDay),
                lunchMeals = days.toLunchMealsUiState(state.value.selectedDay),
                dinnerMeals = days.toDinnerMealsUiState(state.value.selectedDay)
            )
        }
    }

    private fun onError(error: ErrorUIState) {
        _state.update { it.copy(error = error) }
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


    override fun onDaySelected(timestamp: Int) {
        updateSelectedDay(timestamp)
        showSelectedDayMeals(timestamp)
    }

    override fun onPageChanged(position: Int) {
        _state.update { it.copy(pagePosition = position) }
    }

    fun onDateSelected(date: String) {
//        Log.d("SADEQMHANA", "onDateSelected: ${getFormattedDate(date)}")
        Log.d("SADEQMHANA", "onDateSelected without format: $date")
        updateSelectedDay(getTimestamp(date))
        getWeekMealsPlan()
    }

    override fun onDatePickerClicked() {
        viewModelScope.launch { _effect.emit(MealPlanUiEffect.ShowDatePicker) }
    }

    private fun getFormattedDate(timestamp: Int): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val netDate = Date(timestamp.toLong() * 1000)
        Log.d("SADEQMHANA", "getFormattedDate: ${sdf.format(netDate)}")
        return sdf.format(netDate)
    }

    private fun getCurrentTimestamp(): Int {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return (calendar.timeInMillis / 1000).toInt()
    }

    private fun getTimestamp(date: String): Int {
        val sdf = SimpleDateFormat("yyyy-M-d-H-m-s")
        val netDate = sdf.parse(date)
        return (netDate.time / 1000).toInt()
    }

}