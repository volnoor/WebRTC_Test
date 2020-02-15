package com.volnoor.lib_webrtc_test.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentMainBinding
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import com.volnoor.lib_webrtc_test.ui.configuration.ConfigurationFragment

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override fun getLayoutId() = R.layout.fragment_main

    override fun getViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun getBindingVariable() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = ConfigurationFragment.newInstance()
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.layout_container, fragment)
            .commit()
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}