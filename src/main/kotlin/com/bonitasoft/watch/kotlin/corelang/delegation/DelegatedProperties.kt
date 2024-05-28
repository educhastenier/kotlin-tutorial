package com.bonitasoft.watch.kotlin.corelang.delegation

import kotlin.random.Random
import kotlin.reflect.KProperty

fun main() {
    println(lazyValue)
    println(lazyValue)
    println(lazyValue)

    val e = DelegateExample()
    println(e.p)
    e.p = "new String value"
    example { Foo(Random(System.currentTimeMillis()).nextBoolean()) }
}

val lazyValue: String by lazy {
    println("Initial computing of lazy value!")
    "Hello"
}

class DelegateExample {
    var p: String by Delegate()

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String =
            "$thisRef, thank you for delegating '${property.name}' to me!"

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }
}

fun example(computeFoo: () -> Foo) {
    val memoizedFoo by lazy(computeFoo)

    if (memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}

class Foo(private val randomBoolean: Boolean) {

    fun isValid(): Boolean {
        println("Am I valid?: $randomBoolean")
        return randomBoolean
    }

    fun doSomething() {
        println("Some costly function processing")
    }
}
