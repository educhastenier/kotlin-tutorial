package com.bonitasoft.watch.kotlin.corelang.inline

import com.bonitasoft.watch.kotlin.corelang.semantic.User

inline operator fun <reified T : Number> T.plus(other: T) = when (T::class) {
    Byte::class -> toByte() + other.toByte()
    Short::class -> toShort() + other.toShort()
    Int::class -> toInt() + other.toInt()
    Long::class -> toLong() + other.toLong()
    Float::class -> toFloat() + other.toFloat()
    Double::class -> toDouble() + other.toDouble()
    else -> throw IllegalArgumentException("Only numbers of the same type can be added")
} as T

inline fun <reified T> String.convertTo(): T = this as T

val user: User = "some object".convertTo<User>()