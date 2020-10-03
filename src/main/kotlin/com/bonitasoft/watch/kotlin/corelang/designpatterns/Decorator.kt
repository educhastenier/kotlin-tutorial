package com.bonitasoft.watch.kotlin.corelang.designpatterns

/**
* Using <code>by</code> keyword you can delegate all but overridden methods
*/
class HappyMap<K, V>(val map : MutableMap<K, V> = mutableMapOf()) : MutableMap<K, V> by map{

    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            if (this == null) {
                println("Yay! $key")
            }
        }
    }

}