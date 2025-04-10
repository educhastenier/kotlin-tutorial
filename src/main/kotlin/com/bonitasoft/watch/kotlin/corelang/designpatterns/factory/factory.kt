package com.bonitasoft.watch.kotlin.corelang.designpatterns.factory

interface Authenticator {
    fun authenticate()
}

class GoogleAuthenticator : Authenticator {
    override fun authenticate() {
        println("Auth with Google")
    }
}

class FacebookAuthenticator : Authenticator {
    override fun authenticate() {
        println("Auth with Facebook")
    }
}

object AuthenticatorFactory {
    fun createAuthenticator(type: AuthenticatorType): Authenticator = when (type) {
        AuthenticatorType.GOOGLE -> GoogleAuthenticator()
        AuthenticatorType.FACEBOOK -> FacebookAuthenticator()
    }
}

enum class AuthenticatorType {
    GOOGLE, FACEBOOK;
}


// Usage
fun main() {
    val googleAuthenticator = AuthenticatorFactory.createAuthenticator(AuthenticatorType.GOOGLE)
    val facebookAuthenticator = AuthenticatorFactory.createAuthenticator(AuthenticatorType.FACEBOOK)
    googleAuthenticator.authenticate()
    facebookAuthenticator.authenticate()
}