package com.red_velvet.yumhub.ui.fnd_meal

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class FindYourMealAdapter(item: List<SearchRecipeEntity>, listener: FindYourMealInteractionListener) :
    BaseAdapter<SearchRecipeEntity>(item, listener) {
    override val layoutId: Int = R.layout.item_find_your_meal_result
}

interface FindYourMealInteractionListener : BaseInteractionListener {
    fun onRecipeFindYourMealResultClicked(recipeId: Int)

}