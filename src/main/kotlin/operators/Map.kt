package operators

import io.reactivex.Observable

fun main() {

    map()
//    mapError()
}

private fun map() {
    Observable.just(1, 2, 3)
        .map { x -> x * 10 }
        .subscribe {
            println("map item: $it")
        }
}

private fun mapError() {
    /*ClassCastException thrown here.*/
    val a: Any = 0F
    val b = 0.0
    val c: Any = ""

    Observable.just(a, b, c)
        .map { x -> x as Long }
        .subscribe({
            println("map item: $it")
        }, {
            println(it)
        })
}
