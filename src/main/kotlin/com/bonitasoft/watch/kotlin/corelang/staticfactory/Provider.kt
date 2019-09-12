package com.bonitasoft.watch.kotlin.corelang.staticfactory

abstract class Provider<T> {
    var original: T? = null

    abstract fun create(): T

    fun get(): T {
        val t: T = if (original != null) original!! else create()
        original = t
        return t
//        return original ?: create().apply { original = this }
    }

//     fun get(): T = mocked ?: original ?: create().apply { original = this }
//     var mocked: T? = null

     fun lazyGet(): Lazy<T> = lazy { get() }
}