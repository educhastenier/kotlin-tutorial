package com.bonitasoft.watch.kotlin.corelang.staticfactory

fun main() {
//        UserRepository.Companion.mocked = object : UserRepository {
//        override fun getUser() = User("Mocked", 0)
//    }

    println(UserRepository.get().getUser())
}
