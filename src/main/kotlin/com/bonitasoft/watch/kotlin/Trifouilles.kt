package com.bonitasoft.watch.kotlin

val sum: Int.(Int) -> Int = { plus(it) }

// equivalent to:
//fun Int.sum(other: Int) = this + other

fun main() {
    println(5.sum(17))
}
