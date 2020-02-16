package com.volnoor.lib_webrtc_test

import android.app.Application
import android.util.Log

class WebRTCTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
        instance = this;
    }

    companion object {

        private const val TAG = "WebRTCTestApplication"

        private lateinit var instance: WebRTCTestApplication

        @JvmStatic
        fun getInstance() = instance

    }
}