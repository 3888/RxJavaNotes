package operators.combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main() {
//concat()
    merge()

}

/**
 * https://proandroiddev.com/exploring-rxjava-in-android-operators-for-combining-observables-25734080f4be
 *
 * The difference between merge() and concat() is that merge() interweaves output
 * while concat() waits for earlier emissions to complete before processing new emissions.*/
private fun concat() {
    val alphabets1 = Observable
        .interval(500, TimeUnit.MILLISECONDS)
        .map { id: Long -> "concatA$id" }

    val alphabets2 = Observable
        .interval(500, TimeUnit.MILLISECONDS)
        .map { id: Long -> "concatB$id" }

    Observable.concat(alphabets1, alphabets2)
        .subscribe({
            println(it)
        }, {

        })

    Thread.sleep(3000)
}


private fun merge() {
    val alphabets1 = Observable
        .interval(500, TimeUnit.MILLISECONDS)
        .map { id: Long -> "mergeA$id" }

    val alphabets2 = Observable
        .interval(500, TimeUnit.MILLISECONDS)
        .map { id: Long -> "mergeB$id" }

    Observable.merge(alphabets1, alphabets2)
        .subscribe({
            println(it)
        }, {

        })

    Thread.sleep(3000)
}