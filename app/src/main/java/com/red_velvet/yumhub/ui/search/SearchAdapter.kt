package com.red_velvet.yumhub.ui.search

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class SearchAdapter(item: List<SearchRecipeEntity>, listener: SearchInteractionListener) :
    BaseAdapter<SearchRecipeEntity>(item, listener) {
    override val layoutId: Int = R.layout.item_search_card
}

interface SearchInteractionListener : BaseInteractionListener {

    fun onRecipeSearchResultClicked(recipeId: Int)

}