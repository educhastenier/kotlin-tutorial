package com.bonitasoft.watch.kotlin.corelang.staticfactory

class UserRepositoryImpl : UserRepository {

    override fun getUser() = User("Manu", 42)

}
