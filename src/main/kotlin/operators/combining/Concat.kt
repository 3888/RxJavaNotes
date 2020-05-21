package operators.combining

import io.reactivex.Observable


fun main() {
    concat()
}

private fun concat() {
    Observable.concat(
        Observable.just("A1", "B1", "C1", "D1"),
        Observable.just("A2", "B2", "C2", "D2")
    )
        .subscribe({
            println(it)
        }, {
        })
}