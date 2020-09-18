package com.bonitasoft.watch.kotlin.corelang

/**
 * @author Emmanuel Duchastenier
 */
fun getLatency(): Int {
    return (0..30).random()
}

fun main() {
    getLatency().takeIf { it < 15 }
        ?.let {
            println("Ok to join the game with a low latency of $it")
        }
}