package com.bonitasoft.watch.kotlin.corelang.staticfactory

interface UserRepository {

    fun getUser(): User

    companion object UserRepositoryProvider: Provider<UserRepository>() {
        override fun create() = UserRepositoryImpl()
    }

}
