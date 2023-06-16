package com.red_velvet.yumhub.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.red_velvet.yumhub.domain.models.exceptions.NetworkException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel<T>(state: T) : ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    fun <V> tryToExecute(
        callee: suspend () -> V,
        onSuccess: (V) -> Unit,
        onError: (ErrorUIState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ) {
        viewModelScope.launch(dispatcher) {
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