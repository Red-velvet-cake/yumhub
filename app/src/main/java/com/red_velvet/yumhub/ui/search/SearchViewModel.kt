package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.search.SearchUISate.SearchRecipeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase
)  :BaseViewModel()  {
    private  val _uiState = MutableStateFlow(SearchRecipeUIState())
    val uiState : StateFlow<SearchRecipeUIState> = _uiState
}