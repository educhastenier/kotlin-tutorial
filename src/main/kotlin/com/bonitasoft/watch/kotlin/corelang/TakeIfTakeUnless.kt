package com.bonitasoft.watch.kotlin.corelang

/**
 * @author Emmanuel Duchastenier
 */
fun getLatency(): Int {
    return (0..30).random()
}

fun main() {
    getLatency().takeIf { it < 20 }
            ?.let {
                println("can join the game with latency $it")
            }
}