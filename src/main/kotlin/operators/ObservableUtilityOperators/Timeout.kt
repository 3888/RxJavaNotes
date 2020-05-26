package operators.ObservableUtilityOperators

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    timeout()
}

private fun timeout() {
    Observable
        .interval(0, 500, TimeUnit.MILLISECONDS)
        .timeInterval()
        .timeout(300, TimeUnit.MILLISECONDS)
        .subscribe({
            println("item: ${it.value()} time: ${it.time()}  ")
        }, {
            println(it)
        }
        )
    Thread.sleep(3000)

}