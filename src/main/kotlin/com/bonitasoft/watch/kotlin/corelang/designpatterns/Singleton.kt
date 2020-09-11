package com.bonitasoft.watch.kotlin.corelang.designpatterns

// as "static' does not exist, one cannot create a static getInstance() function to ensure singleton.
// Singleton in Kotlin is declared using the 'object' keyword.

object GameMaster {
    private val diceRun = (1..100).shuffled().first()
    fun showDice() {
        println("Game master run the 100-face dice and got a $diceRun")
    }
}
//The GameMaster singleton has a random number as member variable.
//The reason for this random number is to show that there is only one object of the GameMaster class.

fun main() {
    val gameMaster1 = GameMaster
    val gameMaster2 = GameMaster

    gameMaster1.showDice()
    gameMaster2.showDice()

    println(gameMaster1 == gameMaster2)  // true
    println(gameMaster1 === gameMaster2) // true

    val sing1 = Clazz.Unique
    val sing2 = Clazz.Unique
    // val sing2 = Clazz().Unique // Does not compile, it cannot be accessed via an instance of the class

    println(sing1.oneForAll)
    println(sing2.oneForAll)
}

// singleton can also be defined inside a Class:
class Clazz {
    object Unique {
        val oneForAll = (1..999).shuffled().last()
    }
}


// Thx to https://kotlin-code.com for the resources