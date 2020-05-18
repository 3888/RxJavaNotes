package operators.filtering

import io.reactivex.Observable

fun main() {
    take()
}

private fun take() {

    Observable.just(1, 2, 3, 4, 5, 6)
        .take(3)
        .subscribe {
            println("sample item: $it")
        }

}