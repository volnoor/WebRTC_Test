package com.volnoor.lib_webrtc_test.ui.base

import androidx.fragment.app.Fragment

interface ScreenNavigation {

    fun showFragment(fragment: Fragment)

    fun back()
}