package com.red_velvet.yumhub.ui.favorites

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(

) : BaseViewModel<FavoritesUiState, FavoritesUiEffect>(FavoritesUiState()) {

}