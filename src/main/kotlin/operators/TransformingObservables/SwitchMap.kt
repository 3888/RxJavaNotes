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
    Observable.just("A", "B", "C", "D")
        .switchMap { v ->
            Observable.just("1", "2", "3")
                .doOnNext {
                    print("$v$it ")
                }
                .subscribeOn(Schedulers.io())
        }
        .subscribe()

    Thread.sleep(500)
}