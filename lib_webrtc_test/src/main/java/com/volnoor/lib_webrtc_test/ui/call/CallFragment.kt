package com.volnoor.lib_webrtc_test.ui.call

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.WebRTCTestApplication
import com.volnoor.lib_webrtc_test.databinding.FragmentCallBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import org.webrtc.SurfaceViewRenderer

class CallFragment : BaseFragment<FragmentCallBinding, CallViewModel>(), CallNavigator {

    override fun getLayoutId() = R.layout.fragment_call

    override fun getViewModel(): CallViewModel {
        return ViewModelProvider(this).get(CallViewModel::class.java).apply {
            setNavigator(this@CallFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().onViewCreated()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    companion object {

        @JvmStatic
        fun newInstance() = CallFragment()
    }

    override fun getContext(): Context {
        return WebRTCTestApplication.getInstance()
    }

    override fun getFullscreenRendererView(): SurfaceViewRenderer {
        return binding.fullscreenVideoView
    }

    override fun getPipRendererView(): SurfaceViewRenderer {
        return binding.pipVideoView
    }
}