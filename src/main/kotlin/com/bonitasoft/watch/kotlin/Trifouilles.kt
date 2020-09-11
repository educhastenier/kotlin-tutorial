package com.bonitasoft.watch.kotlin

val sum: Int.(Int) -> Int = {
    // print("Sum of $this and $it is: ")
    plus(it)
}
// equivalent to:
//fun Int.sum(other: Int) = this + other

fun main() {
    println(5.sum(17))

    var myClass: MyClass? = null
    println(myClass?.name ?: "toto")
    println(myClass?.name) // prints null if event is null
    myClass = MyClass("Manu")
    println(myClass?.name)
}

class MyClass(val name: String)
