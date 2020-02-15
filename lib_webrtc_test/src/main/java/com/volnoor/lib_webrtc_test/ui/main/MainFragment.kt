package com.volnoor.lib_webrtc_test.ui.main

import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentMainBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun getLayoutId() = R.layout.fragment_main

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}