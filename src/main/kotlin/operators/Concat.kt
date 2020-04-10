package operators

import io.reactivex.Observable

fun main() {

}

private fun concat() {
    val first = Observable.just(1, 2, 3)
    val second = Observable.just(4, 5, 6)

    Observable.concat(first, second)
        .subscribe {
            println("concat item: $it")
        }

}