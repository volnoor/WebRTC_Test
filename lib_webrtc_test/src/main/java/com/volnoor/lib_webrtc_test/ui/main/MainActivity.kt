package com.volnoor.lib_webrtc_test.ui.main

import android.os.Bundle
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.ui.base.BackPressureHandler
import com.volnoor.lib_webrtc_test.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchMainApplication()
    }

    private fun launchMainApplication() {
        val mainFragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.layout_container, mainFragment, mainFragment::class.java.simpleName)
            .commit()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentByTag(MainFragment::class.java.simpleName)

        var handled = false
        if (fragment as? BackPressureHandler != null) {
            handled = fragment.handleBackPressure()
        }

        if (!handled) { // Has not been handled by any fragments
            super.onBackPressed()
        }
    }
}
