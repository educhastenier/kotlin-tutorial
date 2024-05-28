// import kotlin.concurrent.thread
// Threads
//fun main() {
//    repeat(1_000_000){
//        thread{
//            Thread.sleep(500)
//            print(".")
//        }
//    }
//}
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Using coroutines
fun main() = runBlocking {
    repeat(1_000_000) {
        launch {
            delay(500)
            print(".")
        }
    }
}