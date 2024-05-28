package com.bonitasoft.watch.kotlin.corelang.companion

/**
 * @author Emmanuel Duchastenier
 */
class EventManager private constructor() {

    companion object {
        private lateinit var instance: EventManager

        val managerInstance: EventManager
            get() {
                return when {
                    Companion::instance.isInitialized -> instance
                    else -> EventManager()
                }.apply { instance = this }
            }
    }

    fun sendEvent(eventName: String): Boolean {
        println("Event Sent '$eventName'")
        return true
    }
}

fun main() {
    EventManager.managerInstance.sendEvent("Some event")
}