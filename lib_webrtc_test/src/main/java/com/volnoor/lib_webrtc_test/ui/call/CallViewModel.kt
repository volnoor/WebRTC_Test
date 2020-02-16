package com.volnoor.lib_webrtc_test.ui.call

import android.util.Log
import com.volnoor.feature_lib_webrtc.AppRTCClient
import com.volnoor.feature_lib_webrtc.AppRTCFacade
import com.volnoor.feature_lib_webrtc.PeerConnectionClient
import com.volnoor.lib_webrtc_test.ui.base.BaseViewModel

class CallViewModel : BaseViewModel<CallNavigator>() {

    private lateinit var facade: AppRTCFacade

    fun onViewCreated() {
        Log.d(TAG, "onViewCreated")

        facade = AppRTCFacade(
            getNavigator().getContext(),
            getNavigator().getFullscreenRendererView(),
            getNavigator().getPipRendererView(),
            getPeerConnectionParameters(),
            getRoomConnectionParameters(),
            getEventListener()
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

    private fun getEventListener() = object : AppRTCFacade.EventListener {
        override fun onError(error: String) {
            getNavigator().showErrorAndGoBack(error)
        }
    }

    override fun onCleared() {
        Log.d(TAG, "onCleared")
        facade.dispose()
    }

    companion object {

        private const val TAG = "CallViewModel"
    }
}