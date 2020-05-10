package operators.filtering

import io.reactivex.Observable

fun main() {
    distinct()
    distinctUntilChanged()
}

private fun distinct() {
    Observable.just(1, 2, 2, 1, 3, 1, 2)
        .distinct()
        .subscribe {
            println("distinct item: $it")
        }
}

private fun distinctUntilChanged() {
    Observable.just(1, 2, 2, 3, 3, 4, 4, 1, 5, 2)
        .distinctUntilChanged()
        .subscribe {
            println("distinctUntilChanged item: $it")
        }
}