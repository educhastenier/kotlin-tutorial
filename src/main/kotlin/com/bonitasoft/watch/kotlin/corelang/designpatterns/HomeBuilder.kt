package com.bonitasoft.watch.kotlin.corelang.designpatterns

/**
 * @author Emmanuel Duchastenier
 */
data class Process(
    private var name: String? = null,
    private var priority: Int? = null,
) {

    fun setName(name: String) = apply { this.name = name }

    //    fun setPriority(priority: Int): Process {
//        this.priority = priority
//        return this
//    }
    // alternative writing:
    fun setPriority(priority: Int) = apply { this.priority = priority }
}

fun main() {
    println(Process().setName("sudo").setPriority(17))

    Process().apply {
        setName("sudo")
        setPriority(17)
    }

}