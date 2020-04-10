package baseClasses

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    interval(1000, 5000)

}

private fun interval(intervalPeriodMillis: Long, sleepDelayMillis: Long) {
    val seconds = Observable.interval(intervalPeriodMillis, TimeUnit.MILLISECONDS)
    val disposable = seconds
        .subscribe {
            println("Received: $it")
        }

    //sleep 5 seconds
    Thread.sleep(sleepDelayMillis)

    disposable.dispose()

    if (disposable.isDisposed) {
        println("Disposable is disposed!")
    }
}