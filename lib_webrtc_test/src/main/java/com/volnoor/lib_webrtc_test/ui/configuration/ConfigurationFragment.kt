package com.volnoor.lib_webrtc_test.ui.configuration

import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentConfigurationBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment

class ConfigurationFragment : BaseFragment<FragmentConfigurationBinding, ConfigurationViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_configuration

    override fun getViewModel(): ConfigurationViewModel {
        return ViewModelProvider(this).get(ConfigurationViewModel::class.java)
    }

    override fun getBindingVariable() = BR.viewModel

    companion object {

        @JvmStatic
        fun newInstance() = ConfigurationFragment()
    }
}
