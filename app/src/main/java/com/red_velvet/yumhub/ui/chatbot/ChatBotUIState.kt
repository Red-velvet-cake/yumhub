package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.ui.base.BaseUiState
import com.red_velvet.yumhub.ui.base.ErrorUIState

data class ChatBotUIState(
    val isLoading: Boolean = false,
    val error: ErrorUIState? = null,
    ):BaseUiState
