package com.bonitasoft.watch.kotlin.corelang.designpatterns

import org.junit.jupiter.api.Test

/**
 * @author Emmanuel Duchastenier
 */
internal class StrategyTest {

    @Test
    fun test_strategy_override() {
        val someAnimal = UncertainAnimal()
        var sound = someAnimal.makeSound()
        assert(sound == "Meow!") // { "Wrong animal sound!" }
        someAnimal.makeSound = { "Woof!" }
        sound = someAnimal.makeSound()
        assert(sound == "Woof!")
    }
}