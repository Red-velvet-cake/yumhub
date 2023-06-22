package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface DietRecipeInteractionListener:BaseInteractionListener {

    fun doOnRecipeClicked(recipeId: Int)
}