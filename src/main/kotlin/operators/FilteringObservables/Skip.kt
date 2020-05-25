package operators.FilteringObservables

import io.reactivex.Observable

fun main() {
    skip()
}

private fun skip() {

    Observable.just(1, 2, 3, 4, 5, 6)
        .skip(3)
        .subscribe {
            println("skip item: $it")
        }

}