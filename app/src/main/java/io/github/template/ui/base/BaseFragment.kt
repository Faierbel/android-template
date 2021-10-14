package io.github.template.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.template.util.lifecycleAwareVariable
import io.github.template.util.navigateSafe

abstract class BaseFragment<B : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    Fragment() {

    protected var binding: B by lifecycleAwareVariable()

    protected open var viewModel: BaseViewModel? = null

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeNavigationObserver()
    }

    protected open fun initializeNavigationObserver() {
        viewModel?.navCommand?.observe(viewLifecycleOwner) {
            findNavController().navigateSafe(it)
        }
    }
}
