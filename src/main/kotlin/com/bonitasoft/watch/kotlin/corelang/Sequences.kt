package com.bonitasoft.watch.kotlin.corelang

fun main() {
    val elements = 1..100
    val list = elements/*.asSequence()*/.filter { it < 30 }.map { Pair("Small", it) }

    list.forEach(::println)
}