import java.security.Provider
import java.security.Security

/**
 * @author Emmanuel Duchastenier
 */

fun getProviders(): List<Provider> {
    val providers = Security.getProviders()
    val listOfProviders: List<Provider> = providers.asList()
    return listOfProviders
}