package com.red_velvet.yumhub.ui.chatbot

import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ChatBotViewModel @Inject constructor() :
    BaseViewModel<ChatBotUIState, ChatBotUIEffect>(ChatBotUIState()) {
    private val _uiState = MutableStateFlow(ChatBotUIState())
    val uiState: StateFlow<ChatBotUIState> = _uiState


}