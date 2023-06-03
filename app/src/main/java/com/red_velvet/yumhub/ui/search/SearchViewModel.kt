package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.data.remote.dtos.ingredient.IngredientSearchResultDto
import com.red_velvet.yumhub.domain.usecases.recipes.SearchRecipeUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchRecipeUseCase: SearchRecipeUseCase
)  :BaseViewModel()  {
}