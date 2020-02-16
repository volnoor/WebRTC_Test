package com.volnoor.lib_webrtc_test.ui.configuration

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.tbruyelle.rxpermissions2.RxPermissions
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentConfigurationBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import com.volnoor.lib_webrtc_test.ui.call.CallFragment

class ConfigurationFragment : BaseFragment<FragmentConfigurationBinding, ConfigurationViewModel>(),
    ConfigurationNavigator {

    private lateinit var rxPermissions: RxPermissions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rxPermissions = RxPermissions(this)
    }

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

    override fun getRxPermissions(): RxPermissions {
        return rxPermissions
    }

    companion object {

        @JvmStatic
        fun newInstance() = ConfigurationFragment()
    }
}
