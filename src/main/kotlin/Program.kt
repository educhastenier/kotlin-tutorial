import com.bonitasoft.watch.kotlin.corelang.SecurityProviders
import java.security.Security.getProviders

/**
 * @author Emmanuel Duchastenier
 */

fun main() {
//    val providers = SecurityProviders()

//    val allProviders = providers.getProviders()

    SecurityProviders.getProviders().forEach { provider ->
        println(provider.name)
        provider.forEach { (key, value) -> println("\t$key: $value") }
    }
}

fun listProvidersInstance() {
    val providers = getProviders()

    val it = providers.iterator()
    while (it.hasNext()) {
        val provider = it.next()
        println(provider.name)
        provider.forEach { key, value -> println("\t$key: $value") }
    }
}

fun listProviders() {
    val providers = getProviders()

    val it = providers.iterator()
    while (it.hasNext()) {
        val provider = it.next()
        println(provider.name)
        provider.forEach { key, value -> println("\t$key: $value") }
    }
}