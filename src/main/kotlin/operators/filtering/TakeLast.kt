package operators.filtering

import io.reactivex.Observable

fun main() {
    takeLast()
}

private fun takeLast() {
    Observable.just(1, 2, 3, 4, 5, 6)
        .takeLast(3)
        .subscribe {
            println("sample item: $it")
        }

}