package com.red_velvet.yumhub.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.exceptions.NetworkException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel<T : BaseUiState, EFFECT : BaseUIEffect>(state: T) : ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<EFFECT>()
    val effect = _effect.asSharedFlow()

    fun <V> tryToExecute(
        callee: suspend () -> V,
        onSuccess: (V) -> Unit,
        onError: (ErrorUIState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ): Job {
        return viewModelScope.launch(dispatcher) {
            try {
                val result = callee()
                onSuccess(result)
            } catch (e: NetworkException.UnAuthorizedException) {
                onError(ErrorUIState.UnAuthorized)
            } catch (e: NetworkException.NoInternetException) {
                onError(ErrorUIState.NoInternet)
            } catch (e: NetworkException.TimeoutException) {
                onError(ErrorUIState.ConnectionTimeout)
            } catch (e: Exception) {
                onError(ErrorUIState.InternalServerError)
            }
        }
    }

}