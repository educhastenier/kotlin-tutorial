package com.bonitasoft.watch.kotlin.corelang.flow

/**
 * @author Emmanuel Duchastenier
 */
fun isValidType(x: Any): Any = when (x) {
    is String -> print("It's a string")
    specialType(x) -> print("It's an acceptable type")
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
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> print(x.sum())
    }

    val example = ExampleClass("hello")
    // variable property example.x is not OK, unless casted:
    when (example.x) {
        is Int -> print(example.x as Int + 1)
        is String -> print("example.x is of size ${(example.x as String).length}")
        is IntArray -> print((example.x as IntArray).sum())
    }
}