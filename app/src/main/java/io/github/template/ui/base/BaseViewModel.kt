package io.github.template.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import io.github.template.util.LiveEvent
import io.github.template.util.toLiveData

abstract class BaseViewModel : ViewModel() {

    private val _navCommand = LiveEvent<NavDirections>()

    val navCommand get() = _navCommand.toLiveData()

    protected fun navigateTo(directions: NavDirections) {
        _navCommand.value = directions
    }
}
