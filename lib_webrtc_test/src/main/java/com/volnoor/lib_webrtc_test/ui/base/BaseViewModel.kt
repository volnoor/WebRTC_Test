package com.volnoor.lib_webrtc_test.ui.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N : BaseNavigator> : ViewModel() {

    private lateinit var navigatorHolder: WeakReference<N>

    protected fun getNavigator(): N = navigatorHolder.get()!!

    fun setNavigator(navigator: N) {
        navigatorHolder = WeakReference(navigator)
    }
}