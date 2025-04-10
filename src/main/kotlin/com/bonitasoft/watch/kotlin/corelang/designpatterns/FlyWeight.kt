package com.bonitasoft.watch.kotlin.corelang.designpatterns

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

data class Image(val bytes: ByteArray)

class ImageFactory {
    private val cache = mutableMapOf<String, Image>()

    suspend fun getImage(url: String): Image = cache[url] ?: fetchImage(url).also { image ->
        println("put image in cache for key $url")
        cache[url] = image
    }
}

/**
 * Simulates an image fetch from URL
 */
private suspend fun fetchImage(url: String): Image {
    sleep(1000)
    return Image(url.toByteArray())
}


fun main() {
    val factory = ImageFactory()
    val scope = CoroutineScope(Dispatchers.IO)
    runBlocking {
        scope.launch {
            val image = factory.getImage("image")
        }
        scope.launch {
            val image = factory.getImage("image")
        }
    }
}

