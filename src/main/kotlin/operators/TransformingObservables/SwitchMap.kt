package operators.TransformingObservables

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import operators.performLongOperation
import java.util.concurrent.TimeUnit

fun main() {
    switchMap()
}


private fun switchMap() {
    /*
    https://www.baeldung.com/rxjava-flatmap-switchmap
    * */
    Observable.just("First", "Second", "Third", "Four", "Fifth")
        .switchMap { v ->
            performLongOperation(v)
                .doOnNext {
                    println("processing item on thread " + Thread.currentThread().name)
                }
                .subscribeOn(Schedulers.io())
        }
        .subscribe {
            println(
                "$it on thread ${Thread.currentThread().name}"
            )
        }

    Thread.sleep(10000)
}