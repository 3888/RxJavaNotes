package operators.filtering

import io.reactivex.Observable

fun main() {
//    distinct()
//    distinctUntilChanged()

    distinctClasses()
}

private fun distinct() {
    /*
    https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#59a5
    */
    Observable.just(1, 2, 2, 1, 3, 1, 2)
        .distinct()
        .subscribe {
            println("distinct item: $it")
        }
}

private fun distinctClasses() {
    Observable.just(
        User(0, "First"),
        User(0, "First"),
        User(0, "First"),
        UserNext(0, "Second"),
        UserNext(0, "Second"),
        UserNext(0, "Second")
    )
        .distinct()
        .subscribe {
            println("distinct item: $it")
        }
}

private fun distinctUntilChanged() {
    /*
    https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#cff5
    */
    Observable.just(1, 2, 2, 3, 3, 4, 4, 1, 5, 2)
        .distinctUntilChanged()
        .subscribe {
            println("distinctUntilChanged item: $it")
        }
}

data class User(val id: Long, val name: String)

class UserNext(val id: Long, val name: String)