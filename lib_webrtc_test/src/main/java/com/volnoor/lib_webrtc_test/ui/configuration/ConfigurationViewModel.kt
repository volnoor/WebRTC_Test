package com.volnoor.lib_webrtc_test.ui.configuration

import android.Manifest
import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.adapters.TextViewBindingAdapter
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class ConfigurationViewModel : BaseViewModel<ConfigurationNavigator>() {

    val isLoading = ObservableField<Boolean>()

    private var textRoom: String? = null

    val roomTextChangeListener = TextViewBindingAdapter.AfterTextChanged() { text ->
        Log.d(TAG, "afterTextChanged: $text")
        textRoom = text.toString()
    }

    fun onJoinClicked() {
        Log.d(TAG, "onJoinClicked: $textRoom")

        val disposable = getNavigator().getRxPermissions().requestEachCombined(
            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).subscribe { permissions ->
            if (permissions.granted) {
                isLoading.set(true)
                getNavigator().showCallScreen()
            }
        }
    }

    companion object {
        private const val TAG = "ConfigurationViewModel"
    }
}