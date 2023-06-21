package com.red_velvet.yumhub.ui.deit

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter

class DietAdapter (item: List<SearchRecipeEntity>,listener: DietRecipeInteractionListener) :
    BaseAdapter<SearchRecipeEntity>(item, listener) {
    override val layoutId: Int = R.layout.item_diet_card
}