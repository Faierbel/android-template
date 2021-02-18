package io.github.template.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import io.github.template.util.LiveEvent

abstract class BaseViewModel : ViewModel() {

    val navCommand = LiveEvent<NavDirections>()

}
