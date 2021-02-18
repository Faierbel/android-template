package io.github.template.util

import androidx.navigation.NavController
import androidx.navigation.NavDirections

//Workaround for this issue https://github.com/android/sunflower/issues/239#issuecomment-574639687

fun NavController.navigateSafe(direction: NavDirections) {
    currentDestination?.getAction(direction.actionId)?.let { navigate(direction) }
}
