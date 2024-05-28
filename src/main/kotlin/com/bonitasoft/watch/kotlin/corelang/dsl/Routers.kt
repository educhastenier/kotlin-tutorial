/**
 * @author Emmanuel Duchastenier
 */
package com.bonitasoft.watch.kotlin.corelang.dsl

class Request(val method: String, val contents: String) {
    operator fun invoke(function: () -> Unit): Request {
        TODO("Not implemented")
    }
}

class Response(var queryString: String) {
    operator fun invoke(function: () -> Unit): Response {
        TODO("Response.invoke()")
    }
}

class RouteHandler(val request: Request, val response: Response)

fun routeHandler(f: RouteHandler.() -> Unit): RouteHandler.() -> Unit = f

fun main() {
    routeHandler {
        request {
            response {
//                queryString = "params"
            }
        }
    }
}