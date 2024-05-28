package com.bonitasoft.watch.kotlin.corelang.properties

class Student(private val name: String, private val surname: String) {
    val fullName
        get() = "$name $surname"
}

fun main() {
    print(Student("Dumitry", "Corini").fullName)
}