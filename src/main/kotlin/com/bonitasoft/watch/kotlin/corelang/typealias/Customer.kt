package com.bonitasoft.watch.kotlin.corelang.`typealias`

typealias CustomerName = String

data class Customer(val name: CustomerName)

fun validateName(name: CustomerName) = name.length > 1

fun main() {
    println(validateName(Customer("manu").name))
    println(validateName(Customer("a").name))
}