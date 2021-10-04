package operators.TransformingObservables

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import operators.performLongOperation

fun main() {
concatMap()

}

private fun concatMap() {
    Observable.just("A", "B", "C", "D")
        .concatMap { v ->
            Observable.just("1", "2", "3")
                .doOnNext {
                    print("$v$it ")
                }
                .subscribeOn(Schedulers.io())
        }
        .subscribe()

    Thread.sleep(500)
}


