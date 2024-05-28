package com.bonitasoft.watch.kotlin.corelang.flow

/**
 * @author Emmanuel Duchastenier
 */
fun isValidType(x: Any): Any = when (x) {
    is String -> println("It's a string")
    specialType(x) -> println("It's an acceptable type")
    else -> false
}

fun specialType(x: Any): Boolean = when (x) {
    is Number -> true
    is CharSequence -> true
    else -> false
}

data class ExampleClass(var x: Any)

fun main() {
    val x: Any = ""

    // variable x is OK
    when (x) {
        is Int -> println(x + 1)
        is String -> println(x.length + 1)
        is IntArray -> println(x.sum())
    }

    val example = ExampleClass("hello")
    // variable property example.x is not OK, unless casted:
    when (example.x) {
        is Int -> println(example.x as Int + 1)
        is String -> println("example.x is of size ${(example.x as String).length}")
        is IntArray -> println((example.x as IntArray).sum())
    }

    // we can use When alone, as an if-else if alternative:
    val number = 0
    val text: String? = null
    when {
        number > 5 -> println("number is higher than five")
        text == "hello" -> println("number is low, but you can say hello")
        // Else is not even mandatory:
        // else -> println("none of the above")
    }
}