package com.bonitasoft.watch.kotlin.corelang.designpatterns

fun main() {
    // If you turn on local variable type hints
    //  you'll see that list is of type List<String>
    val list = buildList {
        add("text")
//        add(5)
//        add(Person("name"))
    }

    // RandomList<String>
    val randomList = buildRandomList {
        add("String")
    }
}

data class Person(val name: String) : Comparable<Person> {
    override fun compareTo(other: Person) = name.compareTo(other.name)
}

class RandomList<T> {
    private val list = mutableListOf<T>()

    val items get() = list.toList()

    fun add(item: T) {
        list.add(item)
        list.shuffle()
    }
}

inline fun <T> buildRandomList(builder: RandomList<T>.() -> Unit) = RandomList<T>().apply(builder)