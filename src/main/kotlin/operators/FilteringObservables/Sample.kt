package operators.FilteringObservables

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

fun main() {
    sample() // ? for what ?
}

private fun sample() {
    /*
    http://reactivex.io/documentation/operators/sample.html
    */

    Observable.just(1,2,3,4,5)
        .zipWith(Observable.interval(0, 1, TimeUnit.SECONDS),
            BiFunction<Int, Any, Int> { t1, t2 -> t1 }
        )
        .sample(1, TimeUnit.SECONDS)
        .subscribe {
            println("sample item: $it")
        }

    Thread.sleep(10000)

}