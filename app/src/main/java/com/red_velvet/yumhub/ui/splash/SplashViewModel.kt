package com.red_velvet.yumhub.ui.splash


import com.red_velvet.yumhub.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() :BaseViewModel<SplashUIState>(SplashUIState()){


}