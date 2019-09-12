package com.bonitasoft.watch.kotlin.corelang.delegation

/**
 * Example to show:
 *
 * CLASS DELEGATION (composition pattern)
 *
 * @author Emmanuel Duchastenier
 */
interface Player {
    fun playGame()
}

class RpgGamePlayer : Player {

    override fun playGame() {
        println("Killing enemies")
    }
}

class WitcherGamePlayer : Player {
    private val delegatePlayer = RpgGamePlayer()

    override fun playGame() {
        delegatePlayer.playGame()
    }
}

//class WitcherGamePlayer : Player by RpgGamePlayer()
//class HardPlayer(private val player: Player) : Player by player {
//    override fun playGame() {
//        println("Arrrhhhh!")
//        player.playGame()
//    }
//}

fun main() {
    val rpgGamePlayer = RpgGamePlayer()
    rpgGamePlayer.playGame()

    val witcherGamePlayer = WitcherGamePlayer()
    witcherGamePlayer.playGame()

//    val hardPlayer = HardPlayer(witcherGamePlayer)
//    hardPlayer.playGame()
}
