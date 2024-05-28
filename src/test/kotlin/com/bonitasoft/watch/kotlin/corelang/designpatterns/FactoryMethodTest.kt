package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author Emmanuel Duchastenier
 */
internal class FactoryMethodTest {

    @Test
    fun `factoryMethod should not allow access to constructor`() {
        // Cannot do this, constructor is private:
        // val arya = SecretiveGirl()
        val arya1 = SecretiveGirl.Factory.newGirl(16, "Arry")
        assertEquals(16, arya1.age)
        assertEquals("Arry", arya1.name)
        assertEquals("A girl has no desires", arya1.desires)
        val arya2 = SecretiveGirl.newGirl("Cersei Lannister", "Joffrey", "Ilyn Payne")
        assertEquals(17, arya2.age)
        assertEquals("A girl has no name", arya2.name)
        assertEquals("Cersei Lannister, Joffrey, Ilyn Payne", arya2.desires)
    }

}