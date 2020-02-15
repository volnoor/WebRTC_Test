package com.volnoor.lib_webrtc_test.ui.base

interface BackPressureHandler {
    /**
     * @return true if back pressure has been handled
     */
    fun handleBackPressure(): Boolean
}