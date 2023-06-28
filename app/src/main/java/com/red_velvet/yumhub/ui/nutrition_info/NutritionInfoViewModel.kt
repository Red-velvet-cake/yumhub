package com.red_velvet.yumhub.ui.nutrition_info


import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.red_velvet.yumhub.domain.models.recipes.NutritionWidgetEntity
import com.red_velvet.yumhub.domain.usecases.recipes.GetNutritionWidgetUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NutritionInfoViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    private val NutritionInfo: GetNutritionWidgetUseCase
) : BaseViewModel<NutritionInfoUiState, NutritionInfoUiEffect>(
    NutritionInfoUiState()
) {
    private val args = NutritionInfoContainerFragmentArgs.fromSavedStateHandle(stateHandle)

    init {
        Log.i("mustafa", "args ${args.id}")
        getRecipeNutritionInfo(args.id)
        getRecipeNutritionInfoBad(args.id)

    }

    private fun getRecipeNutritionInfoBad(id: Int) {
        tryToExecute(
            { NutritionInfo.invoke(id) },
            ::onGetRecipeNutritionInfoSuccess,
            ::onError
        )
    }

    private fun onGetRecipeNutritionInfoSuccess(nutritionWidget: NutritionWidgetEntity) {
        return _state.update { it.copy(badContent = nutritionWidget.bad.toUiState()) }
    }

    private fun onError(errorUiState: ErrorUIState) {
        _state.update { it.copy(error = errorUiState) }
    }

    private fun getRecipeNutritionInfo(id: Int) {
        tryToExecute(
            { NutritionInfo.invoke(id) },
            ::onGetRecipeNutritionInfoTypeGoodSuccess,
            ::onError
        )
    }

    private fun onGetRecipeNutritionInfoTypeGoodSuccess(nutritionWidget: NutritionWidgetEntity) {
        return _state.update { it.copy(goodContent = nutritionWidget.good.toUiState()) }
    }


}