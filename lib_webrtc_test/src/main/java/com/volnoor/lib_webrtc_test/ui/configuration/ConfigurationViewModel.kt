package com.volnoor.lib_webrtc_test.ui.configuration

import android.Manifest
import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.adapters.TextViewBindingAdapter
import com.volnoor.lib_webrtc_test.data.RoomConfiguration
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class ConfigurationViewModel : BaseViewModel<ConfigurationNavigator>() {

    val textRoomUrl = ObservableField<String>().apply { set("https://appr.tc") }
    val textRoomId = ObservableField<String>().apply { set("") }

    val roomUrlTextChangeListener = TextViewBindingAdapter.AfterTextChanged() { text ->
        Log.d(TAG, "afterTextChanged: $text")
        textRoomUrl.set(text.toString())
    }

    val roomIdTextChangeListener = TextViewBindingAdapter.AfterTextChanged() { text ->
        Log.d(TAG, "afterTextChanged: $text")
        textRoomId.set(text.toString())
    }

    fun onJoinClicked() {
        Log.d(TAG, "onJoinClicked: $textRoomUrl")

        val disposable = getNavigator().getRxPermissions().requestEachCombined(
            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).subscribe { permissions ->
            if (permissions.granted) {
                getNavigator().showCallScreen(
                    RoomConfiguration(
                        textRoomUrl.get()!!,
                        textRoomId.get()!!
                    )
                )
            }
        }
    }

    companion object {
        private const val TAG = "ConfigurationViewModel"
    }
}