package com.bonitasoft.watch.kotlin.corelang.designpatterns

class Printer private constructor() {
    private val uniquePrinterId = (1..100).shuffled().first()

    companion object {
        private val availablePrinters = mutableMapOf<Int, Printer>()

        fun getPrinter(id: Int): Printer {
            availablePrinters[id] = availablePrinters[id] ?: Printer()
            return availablePrinters[id]!!
        }
    }

    fun print() {
        println("Print page from printer: $uniquePrinterId")
    }
}

// test under MultitonTest


// Thx to https://kotlin-code.com for the resources