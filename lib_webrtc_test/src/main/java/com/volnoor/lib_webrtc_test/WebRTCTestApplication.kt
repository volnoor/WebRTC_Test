package com.volnoor.lib_webrtc_test

import android.app.Application
import android.util.Log

class WebRTCTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    companion object {
        const val TAG = "WebRTCTestApplication"
    }
}