package com.red_velvet.yumhub.ui.nutritionalValue

import com.red_velvet.yumhub.ui.base.BaseUIEffect

sealed interface NutritionalValueUIEffect : BaseUIEffect {

    object InvalidSearchInput : NutritionalValueUIEffect

    object  HideKeyboard : NutritionalValueUIEffect


}