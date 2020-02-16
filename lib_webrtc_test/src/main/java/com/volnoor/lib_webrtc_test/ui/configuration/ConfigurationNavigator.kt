package com.volnoor.lib_webrtc_test.ui.configuration

import com.tbruyelle.rxpermissions2.RxPermissions
import com.volnoor.lib_webrtc_test.data.RoomConfiguration
import com.volnoor.lib_webrtc_test.ui.base.BaseNavigator

interface ConfigurationNavigator : BaseNavigator {

    fun showCallScreen(configuration: RoomConfiguration)

    fun getRxPermissions(): RxPermissions
}