package operators.combining

import io.reactivex.Observable


fun main() {
    concat()
}

private fun concat() {
 /*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#ca31
*/
    val first = Observable.just(1, 2, 3)
    val second = Observable.just(4, 5, 6)

    Observable.concat(first, second)
        .subscribe {
            println("concat item: $it")
        }

}