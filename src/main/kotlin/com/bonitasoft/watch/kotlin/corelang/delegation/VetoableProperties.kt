package com.bonitasoft.watch.kotlin.corelang.delegation

import kotlin.properties.Delegates

/**
 * @author Emmanuel Duchastenier
 */
class VetoableProperties {
    var definition: String by Delegates.vetoable("MyDefinition") { _, old, new ->
        val result = new.contains("\u0019")
        if (result) {
            println("/!\\ Invalid value: '$new', keeping the old one: '$old'")
        }
        !result
    }

    var notNullable: String by Delegates.notNull<String>()
}

fun main() {
    val myDef = VetoableProperties()
    println(myDef.definition)
    myDef.definition = "Hi Manu"
    println(myDef.definition)
    myDef.definition = "Inva\u0019lid"
    println(myDef.definition)

    println(myDef.notNullable)

}