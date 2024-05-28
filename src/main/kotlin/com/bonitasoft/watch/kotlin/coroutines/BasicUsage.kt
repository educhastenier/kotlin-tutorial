package com.bonitasoft.watch.kotlin.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Emmanuel Duchastenier
 */
suspend fun main() = coroutineScope {
    println("Starting in thread ${Thread.currentThread().id}")
    launch {
        delay(1000)
        println("Kotlin Coroutines World! (Thread ${Thread.currentThread().id})")
    }
    println("Hello")
}