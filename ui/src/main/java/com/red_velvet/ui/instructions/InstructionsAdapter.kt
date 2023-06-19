package com.red_velvet.ui.instructions

import com.red_velvet.mylibrary.R


class InstructionsAdapter(
    items: List<StepsUiState>,
    listener: StepsInteractionListener
): com.red_velvet.ui.base.BaseAdapter<StepsUiState>(items,listener) {
    override val layoutId = R.layout.item_instrections_step
}

interface StepsInteractionListener : com.red_velvet.ui.base.BaseInteractionListener {
}