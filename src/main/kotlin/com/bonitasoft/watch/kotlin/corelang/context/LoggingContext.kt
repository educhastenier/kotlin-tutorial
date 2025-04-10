package com.bonitasoft.watch.kotlin.corelang.context

import com.bonitasoft.watch.kotlin.corelang.context.LoggingContext
import com.bonitasoft.watch.kotlin.corelang.context.LoggingContext.LoggingContextImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Test context parameters in Kotlin
 */
interface LoggingContext {
    val log: Logger // This context provides a reference to a logger

    companion object LoggingContextImpl : LoggingContext {
        override val log: Logger = LoggerFactory.getLogger("Default-logger")
    }
}

object LoggingContextCustom : LoggingContext {
    override val log: Logger = LoggerFactory.getLogger("LoggingContextCustomLogger")
}


fun startBusinessOperation(loggingContext: LoggingContext) {
    loggingContext.log.info("Operation on context parameter")
}

class ContextReceiverType {
    fun contextReceiverMember() = LoggingContextImpl.log.info("Context receiver member")
}

fun ContextReceiverType.someFunction() {
    contextReceiverMember()
}

fun main() {
    startBusinessOperation(LoggingContext)
    ContextReceiverType().someFunction()
}
