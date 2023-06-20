package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NutritionalValueViewModel @Inject constructor() :
    BaseViewModel<NutritionalValueUIState>(NutritionalValueUIState()) {
}