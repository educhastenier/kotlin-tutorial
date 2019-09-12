package com.bonitasoft.watch.kotlin.corelang.staticfactory

fun main() {
    println(UserRepository.get().getUser())
}


//    UserRepository.UserRepositoryProvider.mocked = object : UserRepository {
//        override fun getUser() = User("Mocked", 0)
//    }