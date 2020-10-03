package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * @author Emmanuel Duchastenier
 */
internal class SlowSingletonTest {

    @Test
    fun testSingleton() {
        println("Test started")
        for (i in 1..3) {
            val total = measureTimeMillis {
                println(SlowSingleton.value)
            }
            println("Took $total ms")
        }
    }
}