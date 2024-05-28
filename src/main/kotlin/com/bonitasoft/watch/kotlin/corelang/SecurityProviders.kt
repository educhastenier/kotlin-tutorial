package com.bonitasoft.watch.kotlin.corelang

import java.security.Provider
import java.security.Security

/**
 * @author Emmanuel Duchastenier
 */
class SecurityProviders {

    fun getProviders(): List<Provider> = Security.getProviders().asList()

    // ~= static method
    companion object {
        fun getProviders(): List<Provider> = Security.getProviders().asList()
    }
}