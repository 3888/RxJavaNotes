package operators.filtering

import io.reactivex.Observable

fun main() {
    filter()
}
/*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#8a02
 */
private fun filter() {
    Observable.just(2, 30, 22, 5, 60, 1)
        .filter { x -> x > 10 }
        .subscribe {
            println("filter item: $it")
        }
}