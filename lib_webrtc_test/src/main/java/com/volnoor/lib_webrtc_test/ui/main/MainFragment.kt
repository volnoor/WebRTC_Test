package com.volnoor.lib_webrtc_test.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.volnoor.lib_webrtc_test.BR
import com.volnoor.lib_webrtc_test.R
import com.volnoor.lib_webrtc_test.databinding.FragmentMainBinding
import com.volnoor.lib_webrtc_test.ui.base.BackPressureHandler
import com.volnoor.lib_webrtc_test.ui.base.BaseFragment
import com.volnoor.lib_webrtc_test.ui.base.ScreenNavigation
import com.volnoor.lib_webrtc_test.ui.configuration.ConfigurationFragment

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(), ScreenNavigation,
    BackPressureHandler {

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

    override fun showFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.layout_container, fragment, TAG_TOP_FRAGMENT)
            .addToBackStack(null)
            .commit()
    }

    override fun back() {
        activity?.onBackPressed()
    }

    override fun handleBackPressure(): Boolean {
        val fragment = childFragmentManager.findFragmentByTag(TAG_TOP_FRAGMENT)

        var handled = false
        if (fragment is BackPressureHandler) {
            handled = fragment.handleBackPressure()
        }

        if (handled) {
            return true // Child fragment has handled back pressure
        }

        if (childFragmentManager.backStackEntryCount > 1) {
            childFragmentManager.popBackStack()
            return true
        }

        return false
    }

    companion object {

        private const val TAG_TOP_FRAGMENT = "TAG_TOP_FRAGMENT"

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}