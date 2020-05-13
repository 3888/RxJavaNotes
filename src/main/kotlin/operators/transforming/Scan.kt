package operators.transforming

import io.reactivex.Observable

/*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#a51d
*/

fun main() {
    scan()
}

private fun scan() {
    Observable.just(1000, 10, 10, 0)
        .scan { t1: Int, t2: Int -> t1 / t2 }
        .subscribe({
            println(it)
        },
            {
                println(it)
            })
}