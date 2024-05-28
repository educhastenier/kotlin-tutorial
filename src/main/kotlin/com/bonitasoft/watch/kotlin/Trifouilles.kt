package com.bonitasoft.watch.kotlin

val sum: Int.(Int) -> Int = {
    // print("Sum of $this and $it is: ")
    plus(it)
}
// equivalent to:
//fun Int.sum(other: Int) = this + other

fun main() {
    println(5.sum(17))

    var student: Student? = null
    println(student?.name ?: "toto")
    println(student?.name)      // prints null if event is null
    student = Student("Manu")

    @Suppress("UNNECESSARY_SAFE_CALL")
    println(student?.name)
}

class Student(val name: String)
