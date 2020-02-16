package com.volnoor.lib_webrtc_test.ui.call

import android.util.Log
import com.volnoor.feature_lib_webrtc.AppRTCClient
import com.volnoor.feature_lib_webrtc.AppRTCFacade
import com.volnoor.feature_lib_webrtc.PeerConnectionClient
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class CallViewModel : BaseViewModel<CallNavigator>() {

    fun onViewCreated() {
        Log.d(TAG, "onViewCreated")

        val facade = AppRTCFacade(
            getNavigator().getContext(),
            getNavigator().getFullscreenRendererView(), getNavigator()
                .getPipRendererView(), getPeerConnectionParameters(), getRoomConnectionParameters()
        )
    }

    private fun getPeerConnectionParameters(): PeerConnectionClient.PeerConnectionParameters {
        return PeerConnectionClient.PeerConnectionParameters(
            true,
            false,
            false,
            0,
            0,
            0,
            0,
            "VP8",
            true,
            false,
            0,
            "OPUS",
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            null
        )
    }

    private fun getRoomConnectionParameters(): AppRTCClient.RoomConnectionParameters {
        val configuration = getNavigator().getConfiguration()

        return AppRTCClient.RoomConnectionParameters(
            configuration.roomUrl, configuration.roomId, false, null
        )
    }

    companion object {

        private const val TAG = "CallViewModel"
    }
}