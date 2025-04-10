package com.bonitasoft.watch.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlin.random.Random

suspend fun <T> retryCoroutine(
    maxAttempts: Int = 3,
    initialDelay: Long = 1000,  // Initial delay in milliseconds
    maxDelay: Long = 4000,      // Max delay in milliseconds
    factor: Double = 1.5,       // Factor to increase the delay each retry
    block: suspend () -> T      // The suspend function that makes the network request
): T {
    var currentDelay = initialDelay
    repeat(maxAttempts - 1) { attempt ->
        try {
            return block() // Try to execute the block
        } catch (e: Exception) {
            println("Attempt ${attempt + 1} failed: ${e.message}")
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
        }
    }
    return block() // Last attempt, throw exception if it fails
}

suspend fun main() {
    val result = retryCoroutine(maxAttempts = 8) {
        Random(System.currentTimeMillis()).nextInt(10).also {
            if (it < 8) throw RuntimeException("Temporary network unavailability")
        }
        return@retryCoroutine "SUCCESS"
    }

    println("Result: $result")
}