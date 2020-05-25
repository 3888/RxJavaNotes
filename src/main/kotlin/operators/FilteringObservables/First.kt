package operators.FilteringObservables

import io.reactivex.Observable

fun main() {
    first()
}

private fun first() {
    Observable.just(2, 30, 22, 5, 60, 1)
        .first(0)
        .subscribe({
         print(it)
        }, {
        }
        )
}