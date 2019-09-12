package com.bonitasoft.watch.kotlin.corelang.builderpattern

data class Dialog(
        val title: String,
        val text: String? = null,
        val onAccept: (() -> Unit)? = null
)

// Usage
val dialog1 = Dialog(
        title = "Some title",
        text = "Great dialog",
        onAccept = { println("I was clicked") }
)
val dialog2 = Dialog(
        title = "Another dialog",
        text = "I have no buttons"
)
val dialog3 = Dialog(title = "Dialog with just a title")

fun main() {
    println(dialog1)
    println(dialog2)
    println(dialog3)
}
fun add(a: Int, b: Int) = a + b