package com.red_velvet.yumhub.ui.instructions

import com.red_velvet.yumhub.R
import com.red_velvet.yumhub.ui.base.BaseAdapter
import com.red_velvet.yumhub.ui.base.BaseInteractionListener

class InstructionsAdapter(
    items: List<StepsUiState>,
    listener: StepsInteractionListener
):BaseAdapter<StepsUiState>(items,listener) {
    override val layoutId = R.layout.item_instrections_step
}

interface StepsInteractionListener : BaseInteractionListener {
}