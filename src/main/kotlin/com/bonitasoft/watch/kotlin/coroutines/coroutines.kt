package com.bonitasoft.watch.kotlin.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    launchWithChannel()
    // another way to do the same things:
    launchWithActor()
}

fun launchWithChannel() = runBlocking<Unit> {
    val chan = Channel<Int>()
    launch(coroutineContext) {
        repeat(10) { i ->
            delay(120)
            chan.send(i)
        }
        chan.close()
    }

    launch(coroutineContext) {
        println("Channel listener ready to receive ...")
        for (i in chan) {
            println(i)
        }
    }
}

fun launchWithActor() = runBlocking<Unit> {
    val printer = actor<Int>(kotlin.coroutines.coroutineContext) {
        println("Actor ready to print ...")
        for (i in channel) {
            println(i)
        }
    }
    launch(kotlin.coroutines.coroutineContext) {
        println("ready to SEND")
        repeat(10) { i ->
            delay(100)
            printer.send(i)
        }
        printer.close()
    }
}