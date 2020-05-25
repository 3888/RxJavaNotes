package operators.FilteringObservables

import io.reactivex.Observable

fun main() {
    skipLast()
}

private fun skipLast() {

    Observable.just(1, 2, 3, 4, 5, 6)
        .skipLast(3)
        .subscribe {
            println("skipLast item: $it")
        }

}