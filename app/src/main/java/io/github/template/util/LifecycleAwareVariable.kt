package io.github.template.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LifecycleAwareVariable<T : Any> : ReadWriteProperty<Fragment, T>, LifecycleObserver {

    private var _value: T? = null

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        thisRef.viewLifecycleOwner.lifecycle.removeObserver(this)
        _value = value
        thisRef.viewLifecycleOwner.lifecycle.addObserver(this)
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>) = _value
        ?: throw IllegalStateException("Trying to call an lifecycle-aware value outside of the view lifecycle, or the value has not been initialized")


    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyView() {
        _value = null
    }
}


@Suppress("unused")
fun <T : Any> Fragment.lifecycleAwareVariable() =
    LifecycleAwareVariable<T>()
