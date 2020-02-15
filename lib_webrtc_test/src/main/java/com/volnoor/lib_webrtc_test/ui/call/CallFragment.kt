package com.volnoor.lib_webrtc_test.ui.call

import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentCallBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment

class CallFragment : BaseFragment<FragmentCallBinding, CallViewModel>() {

    override fun getLayoutId() = R.layout.fragment_call

    override fun getViewModel(): CallViewModel {
        return ViewModelProvider(this).get(CallViewModel::class.java)
    }

    override fun getBindingVariable(): Int = BR.viewModel

    companion object {

        @JvmStatic
        fun newInstance() = CallFragment()
    }
}