package operators.TransformingObservables

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import operators.performLongOperation

fun main() {
concatMap()

}

private fun concatMap() {

    Observable.just("First", "Second", "Third", "Four", "Fifth")
        .concatMap { v ->
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


