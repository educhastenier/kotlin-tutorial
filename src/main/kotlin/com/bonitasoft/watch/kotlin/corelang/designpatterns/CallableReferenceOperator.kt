/**
 * Shows usages of '::', callable reference operator in Kotlin.
 */
package com.bonitasoft.watch.kotlin.corelang.designpatterns

fun sayHello() {
    println("Hello!")
}

val functionReference: () -> Unit = ::sayHello

val constructorReference: (String) -> Person = ::Person

data class Car(val brand: String, val model: String)

val car = Car("Toyota", "Camry")
val propertyReference: (Car) -> String = Car::brand

fun String.upperCaseAndPrint() {
    println(this.uppercase())
}

val upperCaseAndPrint: String.() -> Unit = String::upperCaseAndPrint

fun main() {
    // Calling the function using the reference
    functionReference()

    val person = constructorReference("John")
    println(person.name)

    val brand = propertyReference(car)
    println(brand)

    "hello world".upperCaseAndPrint()
}