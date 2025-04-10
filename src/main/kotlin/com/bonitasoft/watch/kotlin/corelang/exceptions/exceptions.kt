package com.bonitasoft.watch.kotlin.corelang.exceptions

import java.io.File

/**
 * Instead of this heavy try-catch blocks:
 *
 * ```kotlin
 * fun processFile(path: String): ProcessedData {
 *     return try {
 *         val content = File(path).readText()
 *         try {
 *             val json = parseJson(content)
 *             try {
 *                 processData(json)
 *             } catch (e: Exception) {
 *                 logger.error(e) { "Failed to process data" }
 *                 throw e
 *             }
 *         } catch (e: Exception) {
 *             logger.error(e) { "Failed to parse JSON" }
 *             throw e
 *         }
 *     } catch (e: Exception) {
 *         logger.error(e) { "Failed to read file: $path" }
 *         throw e
 *     }
 * }
 * ```
 * The following code uses `runCatching` to handle exceptions in a more readable way:
 */
fun processFile(path: String): ProcessedData {
    return runCatching { File(path).readText() }
        .onFailure { e -> println("Error: Failed to read file: $path") }
        .mapCatching { content -> parseJson(content) }
        .onFailure { e -> println("Error: Failed to parse JSON") }
        .mapCatching { json -> processData(json) }
        .onFailure { e -> println("Error: Failed to process data") }
        .getOrThrow()
}

fun parseJson(string: String) = "Json: $string"

fun processData(value: String) = ProcessedData(value)

class ProcessedData(var value: String)
