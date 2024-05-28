package com.bonitasoft.watch.kotlin.corelang.designpatterns

import kotlin.properties.Delegates

interface TextChangedListener {
    fun onTextChanged(oldText: String, newText: String)
}

class PrintingTextChangedListener : TextChangedListener {
    override fun onTextChanged(oldText: String, newText: String) =
        println("Text is changed: $oldText -> $newText")
}

class TextView {
    var listeners = mutableListOf<TextChangedListener>()

    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach { it.onTextChanged(old, new) }
    }
}

fun main() {
    val textView = TextView().apply {
        listeners.add(PrintingTextChangedListener())
    }
    
    with(textView) {
        text = "Lorem ipsum"     // println(text)
        text = "dolor sit amet"  // println(text)
    }
}