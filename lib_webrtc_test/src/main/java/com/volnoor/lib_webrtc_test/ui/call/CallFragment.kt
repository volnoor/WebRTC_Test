package com.volnoor.lib_webrtc_test.ui.call

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.WebRTCTestApplication
import com.volnoor.lib_webrtc_test.data.RoomConfiguration
import com.volnoor.lib_webrtc_test.databinding.FragmentCallBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import org.webrtc.SurfaceViewRenderer

class CallFragment : BaseFragment<FragmentCallBinding, CallViewModel>(), CallNavigator {

    private lateinit var configuration: RoomConfiguration

    override fun getLayoutId() = R.layout.fragment_call

    override fun getViewModel(): CallViewModel {
        return ViewModelProvider(this).get(CallViewModel::class.java).apply {
            setNavigator(this@CallFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuration = arguments?.getParcelable(ARG_CONFIGURATION)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewModel().onViewCreated()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    companion object {

        private const val ARG_CONFIGURATION = "ARG_CONFIGURATION"

        @JvmStatic
        fun newInstance(configuration: RoomConfiguration) =
            CallFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CONFIGURATION, configuration)
                }
            }
    }

    override fun getContext() = WebRTCTestApplication.getInstance()

    override fun getConfiguration() = configuration

    override fun getFullscreenRendererView(): SurfaceViewRenderer {
        return binding.fullscreenVideoView
    }

    override fun getPipRendererView(): SurfaceViewRenderer {
        return binding.pipVideoView
    }
}