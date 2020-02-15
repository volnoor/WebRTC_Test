package com.volnoor.lib_webrtc_test.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel<out BaseNavigator>>
    : Fragment() {

    private lateinit var binding: B
    private lateinit var viewModel: V
    protected lateinit var screenNavigation: ScreenNavigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        var fragment = parentFragment
        while (fragment != null) {
            if (fragment is ScreenNavigation) {
                screenNavigation = fragment
                break
            }
            fragment = fragment.parentFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        return binding.root
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModel(): V

    protected abstract fun getBindingVariable(): Int
}