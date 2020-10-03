package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Emmanuel Duchastenier
 */
internal class DecoratorTest {

    @Test
    fun testDecorator() {
        val map = HappyMap<String, String>()
        map["A"] = "B"
        map["B"] = "C"
        map["A"] = "C"
        map.remove("A")
        map["A"] = "C"
        assertEquals(mapOf("A" to "C", "B" to "C"), map.map)
//        assertEquals(listOf("Yay! A", "Yay! B", "Yay! A"), map.values)
    }
}