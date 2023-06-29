package com.red_velvet.yumhub.ui.chatbot

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.recipes.QuickAnswerEntity
import com.red_velvet.yumhub.domain.models.recipes.SearchRecipeEntity
import com.red_velvet.yumhub.domain.usecases.recipes.GetQuickAnswerUseCase
import com.red_velvet.yumhub.domain.usecases.recipes.SendMessageUseCase
import com.red_velvet.yumhub.ui.base.BaseViewModel
import com.red_velvet.yumhub.ui.base.ErrorUIState
import com.red_velvet.yumhub.ui.search.toRecipeSearchResultMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatBotViewModel @Inject constructor(
    private val quickAnswer: GetQuickAnswerUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) :
    BaseViewModel<ChatBotUIState, ChatBotUIEffect>(ChatBotUIState()) {
    private val _uiState = MutableStateFlow(ChatBotUIState())
    val uiState: StateFlow<ChatBotUIState> = _uiState
    fun onInputSearchChange(quickAnswer: CharSequence) {
        _uiState.update { it.copy(quickAnswer = quickAnswer.toString()) }
    }

    init {
        getAllMessages()
    }
     fun onSend(){
         if(_uiState.value.quickAnswer.isEmpty()){
             return
         }
         tryToExecute(
             callee ={
                 sendMessageUseCase.invoke(_uiState.value.quickAnswer)
             },
             onSuccess = ::onSuccessSendMessage,
                onError = ::onError
         )
     }
    private  fun getAllMessages(){
        tryToExecute(
            callee =quickAnswer::invoke,
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }
    private fun onSuccessSendMessage(response: Any) {
        Log.i("RESPONSE", response.toString())
    }
    private fun onSuccess(recipes: Flow<List<QuickAnswerEntity>>) {
        viewModelScope.launch {
            recipes.collect{items->
                val result= items.toMapper()
                Log.i("AYA", result.toString())
                _uiState.update {
                    it.copy(
                        quickAnswerResult = result,
                        isLoading = false,
                        quickAnswer = ""
                    )
                }
            }
        }
    }
    private fun onError(errorUiState: ErrorUIState) {
        Log.i("AYA", errorUiState.toString())
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

}