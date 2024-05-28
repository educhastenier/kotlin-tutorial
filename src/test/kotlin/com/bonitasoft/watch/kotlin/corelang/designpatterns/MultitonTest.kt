package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Emmanuel Duchastenier
 */
internal class MultitonTest {

    @Test
    fun check_multiton_with_same_ids_are_identical() {
        Printer.getPrinter(17).print()
        Printer.getPrinter(17).print()
        Printer.getPrinter(9).print()
        Printer.getPrinter(17).print()
        Printer.getPrinter(9).print()
        assertEquals(Printer.getPrinter(28), Printer.getPrinter(28))
    }
}