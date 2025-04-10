package com.bonitasoft.watch.kotlin.corelang.covariant

// InExample limits the return type to T,
// meaning InExample cannot have T as one of its output parameters.
interface InExample<in T> {
    fun consume(input: T)
    // fun returnConsumed(): T // Would not compile
}

// Usage
class StringInExample : InExample<String> {
    override fun consume(input: String) {
        println(input)
    }
}

fun main() {
    val example: InExample<String> = StringInExample()
    example.consume("Just a string") // Just a string
}