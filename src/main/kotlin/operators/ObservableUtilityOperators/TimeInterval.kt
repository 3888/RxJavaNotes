package operators.ObservableUtilityOperators

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main() {
    timeInterval()
}

private fun timeInterval() {
    val disposable = Observable
        .interval(0, 1, TimeUnit.SECONDS)
        .timeInterval()
        .subscribe {
            println("item: ${it.value()} time: ${it.time()}  ")
        }
    Thread.sleep(4000)
}

