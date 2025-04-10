package com.bonitasoft.watch.kotlin.corelang.covariant

// OutExample limits the input type to T,
// meaning OutExample cannot have it as one of its input parameters.
interface OutExample<out T> {
    fun returnValue(): T
    // fun processValue(input: T) // Would not compile
}

// Usage
class StringOutExample : OutExample<String> {
    override fun returnValue() = "Just a string"
}

fun main() {
    val example: OutExample<String> = StringOutExample()
    println(example.returnValue()) // Just a string
}