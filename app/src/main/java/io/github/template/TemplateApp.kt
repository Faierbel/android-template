package io.github.template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.template.util.DebugLogTree
import timber.log.Timber

@HiltAndroidApp
class TemplateApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeTimber()
    }

    private fun initializeTimber() {
        Timber.plant(DebugLogTree())
    }
}
