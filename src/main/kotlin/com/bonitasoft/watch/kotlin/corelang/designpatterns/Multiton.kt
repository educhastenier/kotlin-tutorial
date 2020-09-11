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

interface IPrinter{
    val randomNumber : Int
    fun print()
}

class ClientPrinter : IPrinter{
    override val randomNumber = (1..100).shuffled().first()
    override fun print() {
        println("Print page from client printer: $randomNumber")
    }
}

class TablePrinter : IPrinter{
    override val randomNumber = (1..100).shuffled().first()
    override fun print() {
        println("Print page from table printer: $randomNumber")
    }
}

object PrinterHost{
    private var availablePrinter = mutableMapOf<Int, IPrinter>()

    fun <TType>registerPrinter(id: Int, printer : TType)
            where TType : IPrinter
    {
        availablePrinter[id] = printer
    }

    fun <TType>getTypedPrinter(id : Int) : TType{
        return getPrinter(id)!! as TType
    }

    fun getPrinter(id : Int) : IPrinter{
        val printer = availablePrinter[id]

        if(printer == null){
            // handle somehow this case
        }

        return printer!!
    }
}