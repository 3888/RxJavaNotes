package operators.ConditionalAndBooleanOperators

import io.reactivex.Observable

fun main() {
    defaultIfEmpty()
}

private fun defaultIfEmpty() {
    Observable.just(1, 2, 3)
//        .filter { it < 1 }
        .skip(3)
        .defaultIfEmpty(0)
        .subscribe({
            print(it)
        }, {
        }
        )
}