package com.volnoor.lib_webrtc_test.ui.configuration

import android.util.Log
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class ConfigurationViewModel : BaseViewModel<ConfigurationNavigator>() {

    fun onJoinClicked() {
        Log.d(TAG, "onJoinClicked")
        getNavigator().showCallScreen()
    }

    companion object {
        private const val TAG = "ConfigurationViewModel"
    }
}