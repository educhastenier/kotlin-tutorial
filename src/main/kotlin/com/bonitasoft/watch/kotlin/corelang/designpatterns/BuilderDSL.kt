package com.bonitasoft.watch.kotlin.corelang.designpatterns

import java.io.File

// Let's assume that DialogBox class is provided by external library.
// We have only access to Dialog public interface which cannot be changed.
class DialogBox {

    fun showTitle() = println("showing title")

    fun setTitle(text: String) = println("setting title text $text")

    fun setTitleColor(color: String) = println("setting title color $color")

    fun showMessage() = println("showing message")

    fun setMessage(text: String) = println("setting message $text")

    fun setMessageColor(color: String) = println("setting message color $color")

    fun showImage(bitmapBytes: ByteArray) = println("showing image with size ${bitmapBytes.size}")

    fun show() = println("showing dialog $this")
}

//Builder:
class DialogBoxBuilder() {
    constructor(init: DialogBoxBuilder.() -> Unit) : this() {
        init()
    }

    private var titleHolder: TextView? = null
    private var messageHolder: TextView? = null
    private var imageHolder: File? = null

    fun title(init: TextView.() -> Unit) {
        titleHolder = TextView().apply { init() }
    }

    fun message(init: TextView.() -> Unit) {
        messageHolder = TextView().apply { init() }
    }

    fun image(init: () -> File) {
        imageHolder = init()
    }

    fun build(): DialogBox {
        val dialog = DialogBox()

        titleHolder?.apply {
            dialog.setTitle(text)
            dialog.setTitleColor(color)
            dialog.showTitle()
        }

        messageHolder?.apply {
            dialog.setMessage(text)
            dialog.setMessageColor(color)
            dialog.showMessage()
        }

        imageHolder?.apply {
            dialog.showImage(readBytes())
        }

        return dialog
    }

    class TextView {
        var text: String = ""
        var color: String = "#00000"
    }
}

//Function that creates dialog builder and builds Dialog
fun dialog(init: DialogBoxBuilder.() -> Unit): DialogBox {
    return DialogBoxBuilder(init).build()
}

val dialog: DialogBox = dialog {
    title {
        text = "Dialog Title"
    }
    message {
        text = "Dialog Message"
        color = "#333333"
    }
    image {
        File.createTempFile("image", "jpg")
    }
}

fun main() {
    dialog.show()
}
