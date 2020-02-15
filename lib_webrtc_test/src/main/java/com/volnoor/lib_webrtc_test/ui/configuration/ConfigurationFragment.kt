package com.volnoor.lib_webrtc_test.ui.configuration

import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentConfigurationBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import com.volnoor.lib_webrtc_test.ui.call.CallFragment

class ConfigurationFragment : BaseFragment<FragmentConfigurationBinding, ConfigurationViewModel>(),
    ConfigurationNavigator {

    override fun getLayoutId(): Int = R.layout.fragment_configuration

    override fun getViewModel(): ConfigurationViewModel {
        return ViewModelProvider(this).get(ConfigurationViewModel::class.java).apply {
            setNavigator(this@ConfigurationFragment)
        }
    }

    override fun getBindingVariable() = BR.viewModel

    override fun showCallScreen() {
        val fragment = CallFragment.newInstance()
        screenNavigation.showFragment(fragment)
    }

    companion object {

        @JvmStatic
        fun newInstance() = ConfigurationFragment()
    }
}
