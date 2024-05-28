package com.bonitasoft.watch.kotlin.corelang.designpatterns

/**
 * @author Emmanuel Duchastenier
 */
class SecretiveGirl private constructor(
    val age: Int,
    val name: String = "A girl has no name",
    val desires: String = "A girl has no desires"
) {
    companion object Factory {
        fun newGirl(vararg desires: String): SecretiveGirl {
            return SecretiveGirl(17, desires = desires.joinToString(", "))
        }

        fun newGirl(age: Int = 17, name: String): SecretiveGirl {
            return SecretiveGirl(age, name)
        }
    }
}

// Thx to https://proandroiddev.com for the resources