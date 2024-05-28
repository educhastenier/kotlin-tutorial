package com.bonitasoft.watch.kotlin.corelang.lazy

import com.bonitasoft.watch.kotlin.corelang.staticfactory.User

/**
 * @author Emmanuel Duchastenier
 */
class HeavyInitService {
    val user: User by lazy { computeHeavyInitializationUser() }

    private fun computeHeavyInitializationUser(): User {
        println("Initialization of heavy computation of User")
        val user = User("Lazy", 12)
        println("Finished Heavy computation of User")
        return user
    }
}

fun main() {
    println("début")
    val service = HeavyInitService()
    println("Service initialisé. User not initialized yet.")
    service.user
    println("HeavyInitService.user accédé, donc initialisé")
    println("Fin")
}