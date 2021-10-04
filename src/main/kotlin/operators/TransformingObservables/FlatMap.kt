package operators.TransformingObservables

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import operators.performLongOperation
import kotlin.random.Random


fun main() {

//    flatMap()
    flatMap2()

//    flatMapSingle(6).subscribe()

}

private fun flatMap() {
    /*
Порядок, в котором объединяются наблюдаемые, не гарантируется таким же, как в исходном Observable
https://stackoverflow.com/questions/53682216/rxjava-schedulers-io-doesnt-work-in-maven-project
 */

    Observable.just("A", "B", "C", "D")
        .flatMap { v ->
            Observable.just("1", "2", "3")
                .doOnNext {
                    print("$v$it ")
                }
                .subscribeOn(Schedulers.io())
        }
        .subscribe()

    Thread.sleep(500)
}

private fun flatMap2() {
    Observable.just("First", "Second", "Third", "Four", "Fifth")
        .flatMap {
            performLongOperation(it)
                .doOnNext {
                    println("$it processing item on thread " + Thread.currentThread().name)
                }
                .subscribeOn(Schedulers.newThread())
        }
        .subscribe {
            println(
                "$it on thread ${Thread.currentThread().name}"
            )
        }

    Thread.sleep(3000)

}


private fun flatMapSingle(value: Int): Single<Boolean> =
    Single.just(value)
        .flatMap {
            println("$it < 5")
            if (value < 5) {
                Single.fromCallable {
                    println(it <= 5)
                    true
                }
            } else {
                Single.fromCallable {
                    println(it <= 5)
                    false
                }
            }
        }

