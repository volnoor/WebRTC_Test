package com.volnoor.lib_webrtc_test.ui.call

import android.content.Context
import com.volnoor.lib_webrtc_test.data.RoomConfiguration
import com.volnoor.lib_webrtc_test.ui.base.BaseNavigator
import org.webrtc.SurfaceViewRenderer

interface CallNavigator : BaseNavigator {

    fun getContext(): Context

    fun getConfiguration(): RoomConfiguration

    fun getFullscreenRendererView(): SurfaceViewRenderer

    fun getPipRendererView(): SurfaceViewRenderer

    fun showErrorAndGoBack(error: String)
}