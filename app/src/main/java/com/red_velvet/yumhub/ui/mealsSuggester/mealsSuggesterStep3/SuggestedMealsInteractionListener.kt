package com.red_velvet.yumhub.ui.mealsSuggester.mealsSuggesterStep3

import com.red_velvet.yumhub.ui.base.BaseInteractionListener

interface SuggestedMealsInteractionListener:BaseInteractionListener {
    fun onMealClick(id:Int)
}