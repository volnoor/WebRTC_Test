package com.volnoor.lib_webrtc_test.ui.configuration

import android.util.Log
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class ConfigurationViewModel : BaseViewModel() {

    fun onJoinClicked() {
        Log.d(TAG, "onJoinClicked")
    }

    companion object {
        private const val TAG = "ConfigurationViewModel"
    }
}