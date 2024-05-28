package com.bonitasoft.watch.kotlin.corelang.designpatterns

/**
 * Using <code>by</code> keyword you can delegate all but overridden methods
 */
class TalkativeMap<K, V>(val map: MutableMap<K, V> = mutableMapOf()) : MutableMap<K, V> by map { // Here 'by' keyword indicates Delegation, not inheritance

    override fun put(key: K, value: V): V? {
        return map.put(key, value)
            .apply {
            if (this == null) {
                println("$key was empty when putting $value")
            }
        }
    }

}