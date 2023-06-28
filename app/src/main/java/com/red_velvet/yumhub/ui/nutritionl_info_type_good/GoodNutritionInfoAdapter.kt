package com.red_velvet.yumhub.ui.nutritionl_info_type_good

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.NutritionalInfoEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter

class GoodNutritionInfoAdapter(items: List<NutritionalInfoEntity>) :
    BaseAdapter<NutritionalInfoEntity>(items) {
    override val layoutId: Int = R.layout.item_nutrition_info
}