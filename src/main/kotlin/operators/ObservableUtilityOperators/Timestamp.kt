package operators.ObservableUtilityOperators

import io.reactivex.Observable
import java.sql.Timestamp
import java.util.concurrent.TimeUnit

fun main() {
    timeStamp()
}

private fun timeStamp() {
  Observable
        .interval(0, 1, TimeUnit.SECONDS)
        .timestamp()
        .subscribe {
            println("item: ${it.value()} time: ${Timestamp(it.time())}  ")
        }
    Thread.sleep(4000)
}
