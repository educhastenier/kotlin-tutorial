package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Emmanuel Duchastenier
 */
internal class DecoratorTest {

    @Test
    fun testDecorator() {
        val map = TalkativeMap<String, String>()
        map["A"] = "B"
        map["B"] = "C"
        map["A"] = "C"
        map.remove("A")
        map["A"] = "D"
        assertEquals(mapOf("A" to "D", "B" to "C"), map.map)
    }
}