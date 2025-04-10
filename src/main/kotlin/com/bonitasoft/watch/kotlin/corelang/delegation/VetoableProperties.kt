package com.bonitasoft.watch.kotlin.corelang.delegation

import kotlin.properties.Delegates

/**
 * @author Emmanuel Duchastenier
 */
class VetoableProperties {
    var definition: String by Delegates.vetoable("MyDefinition") { _, old, new ->
        val valid = !new.contains("\u0019")
        if (!valid) {
            println("/!\\ Invalid value: '$new', keeping the old one: '$old'")
        }
        valid
    }

    var notNullable: String by Delegates.notNull()
}

fun main() {
    val myDef = VetoableProperties()
    println(myDef.definition)
    myDef.definition = "Hi Manu"
    println(myDef.definition)
    myDef.definition = "Inva\u0019lid"
    println(myDef.definition)

    try {
        println(myDef.notNullable)
    } catch (e: IllegalStateException) {
        println("Getting non-nullable value is not allowed before initialization: '${e.message}'. Going on anyway...")
    }
    // This try-catch block can also be written as:
    // println(runCatching { myDef.notNullable }
    //     .getOrElse { "Getting non-nullable value not allowed before initialization: '${it.message}'. ..." })

    myDef.notNullable = "Valid non nullable value once set"
    println(myDef.notNullable)

}