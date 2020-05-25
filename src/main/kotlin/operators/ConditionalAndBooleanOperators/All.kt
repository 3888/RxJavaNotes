package operators.ConditionalAndBooleanOperators

import io.reactivex.Observable

fun main() {
    all()
}

private fun all() {
    Observable.just(2, 30, 22, 5, 60, 1)
        .all {
            it > 0
        }
        .subscribe({
            print(it)
        }, {
        }
        )
}