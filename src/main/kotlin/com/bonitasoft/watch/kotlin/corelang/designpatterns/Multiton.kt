package com.bonitasoft.watch.kotlin.corelang.designpatterns

class Printer private constructor() {
    private val randomNumber = (1..100).shuffled().first()

    companion object /*AvailablePrinter*/ {
        private val availablePrinter = mutableMapOf<Int, Printer>()

        fun getPrinter(id: Int): Printer {
            availablePrinter[id] = availablePrinter[id] ?: Printer()
            return availablePrinter[id]!!
        }
    }

    fun print() {
        println("Print page from printer: $randomNumber")
    }
}

fun main() {
    Printer.getPrinter(17).print()
    Printer.getPrinter(17).print()
    Printer.getPrinter(9).print()
}


// Thx to https://kotlin-code.com for the resources