package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.ui.base.BaseAdapter

class MessageAdapter (item: List<QuickAnswerEntity>) :
    BaseAdapter<QuickAnswerEntity>(item) {
    override val layoutId: Int = R.layout.item_mesage


}