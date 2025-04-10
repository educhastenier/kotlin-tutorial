/**
 * Example of delegation over inheritance
 */
package com.bonitasoft.watch.kotlin.corelang.delegation

import kotlin.properties.ObservableProperty

interface AnalyticsLogger {
    fun registerLifecycleOwner(owner: LifecycleOwner)
}

interface LifecycleOwner {

    val lifecycle: ObservableProperty<Any>
}

open class LifecycleEventObserver : LifecycleOwner {
    override val lifecycle: ObservableProperty<Any>
        get() = TODO("Not yet implemented")

}

class AnalyticsLoggerImpl : AnalyticsLogger {

    override fun registerLifecycleOwner(owner: LifecycleOwner) {
        // so something with owner
    }

}

interface DeepLinkHandler {
    fun handleDeepLink(activity: Activity)
}

class DeepLinkHandlerImpl : DeepLinkHandler {
    override fun handleDeepLink(activity: Activity) {
        // Handle the intent
    }
}

open class Activity {
    open fun onCreate() {
        // Do something
    }
}

class MainActivity : Activity(),
    AnalyticsLogger by AnalyticsLoggerImpl(),         // several delegations
    DeepLinkHandler by DeepLinkHandlerImpl(),
    LifecycleOwner by LifecycleEventObserver() {      // here, instead of inheritance
    override fun onCreate() {
        // do something else
    }
}

fun main() {
    val mainActivity = MainActivity()
    mainActivity.onCreate()
    mainActivity.handleDeepLink(mainActivity)
    mainActivity.registerLifecycleOwner(mainActivity)
}
