import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    testChannel()
}

suspend fun testChannel() = coroutineScope {
    val channel = Channel<Int>()

    launch {
        for (n in 1..10) {
            channel.send(n)
        }
    }
    repeat(times = 5){
        println(channel.receive())
    }
    println("end")
}