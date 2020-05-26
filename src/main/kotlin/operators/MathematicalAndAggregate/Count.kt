package operators.MathematicalAndAggregate

import io.reactivex.Observable


fun main() {
    count()
}

private fun count() {
    Observable.just("A1", "B1", "C1", "D1")
        .count()
        .subscribe({
            println(it)
        }, {
        })
}