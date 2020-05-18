package operators.filtering

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

fun main() {
    sample() // not working (
}

private fun sample() {
    /*
    http://reactivex.io/documentation/operators/sample.html
    */

    Observable.just(1,2,3,4,5,6)
        .zipWith(Observable.interval(0, 1, TimeUnit.SECONDS), object : BiFunction<Int, Any, Int> {
            override fun apply(t1: Int, t2: Any): Int {
                return t1
            }
        }
        )
        .sample(2, TimeUnit.SECONDS)
        .subscribe {
            println("sample item: $it")
        }

}