package com.volnoor.lib_webrtc_test.ui.main

import android.os.Bundle
import com.volnoor.lib_webrtc_test.R
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
            .add(R.id.layout_container, mainFragment)
            .commit()
    }
}
