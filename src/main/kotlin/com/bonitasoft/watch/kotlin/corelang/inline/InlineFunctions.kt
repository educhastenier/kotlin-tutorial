package com.bonitasoft.watch.kotlin.corelang.inline

import com.bonitasoft.watch.kotlin.corelang.inline.CommonLock.unique
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import javax.swing.text.AbstractDocument
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeNode

/**
 * @author Emmanuel Duchastenier
 */
inline fun <T> lock(lock: Lock, blockCode: () -> T): T {
    lock.lock()
    try {
        return blockCode()
    } finally {
        lock.unlock()
    }
}

object CommonLock {
    val unique = ReentrantLock()
}

suspend fun root(): Unit = coroutineScope {
    launch {
        repeat(10) { i ->
            delay(500)
            lock(unique) {
                doSomething(i)
            }
        }
    }

    DefaultMutableTreeNode().findParentOfType<DefaultMutableTreeNode>()

}

fun doSomething(i: Int) {
    println("Hello $i")
}

inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

inline fun <reified T> membersOf() = T::class.members

fun main() {
    // println(membersOf<StringBuilder>().joinToString("\n"))
    println(foo)
}

data class Foo(val bar: String)

val foo: Foo
    inline get() = Foo("pitou")
