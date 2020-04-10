package operators

import io.reactivex.Observable

fun main() {

}

private fun filter() {
    Observable.just(2, 30, 22, 5, 60, 1)
        .filter { x -> x > 10 }
        .subscribe {
            println("filter item: $it")
        }
}