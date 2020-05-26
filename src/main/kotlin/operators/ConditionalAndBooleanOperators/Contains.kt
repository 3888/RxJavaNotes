package operators.ConditionalAndBooleanOperators

import io.reactivex.Observable

fun main() {
    contains()
}

private fun contains() {
    Observable.just(2, 30, 22, 5, 60, 1)
        .contains("")
        .subscribe({
            print(it)
        }, {
        }
        )
}