package com.bonitasoft.watch.kotlin.corelang.semantic

fun join(separator: String, strings: List<String>): String {
    require(separator.length > 2) { "separator length must be > 2" }
//    checkNotNull(separator)
    return strings.joinToString(separator = separator)
}

fun main() {
    println(join(" - ", listOf("manu", "val", "loic")))
    println(join("-", listOf("manu", "val", "loic")))
}

class User(val name: String?)

fun printName(user: User?){
    val name = user?.name?:throw IllegalArgumentException("User / its name is null")
    println("Name is $name")
}