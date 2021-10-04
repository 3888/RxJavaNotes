package operators.CombiningObservables

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main() {
//    concat()
//    println()
    merge()

}

/**
 * https://proandroiddev.com/exploring-rxjava-in-android-operators-for-combining-observables-25734080f4be
 *
 * The difference between merge() and concat() is that merge() interweaves output
 * while concat() waits for earlier emissions to complete before processing new emissions.*/
private fun concat() {
    val alphabets1 = Observable.just("A","B","C")
//        .interval(200, TimeUnit.MILLISECONDS)
//        .map { id: Long -> "concatA$id" }

    val alphabets2 = Observable.just("D","E","F")
//        .interval(100, TimeUnit.MILLISECONDS)
//        .map { id: Long -> "concatB$id" }

    Observable.concat(alphabets2,alphabets1)
        .subscribe({
            print(it)
        }, {

        })

    Thread.sleep(1000)
}

private fun merge() {
    val alphabets1 = Observable
        .interval(100, TimeUnit.MILLISECONDS)
        .map { id: Long -> "mergeA$id" }

    val alphabets2 = Observable
        .interval(100, TimeUnit.MILLISECONDS)
        .map { id: Long -> "mergeB$id" }

    Observable.merge(alphabets1, alphabets2)
        .subscribe({
            println(it)
        }, {

        })

    Thread.sleep(1000)
}

//TODO https://blog.mindorks.com/rxjava-operator-concat-vs-merge ??? not working