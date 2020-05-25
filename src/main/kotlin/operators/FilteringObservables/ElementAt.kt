package operators.FilteringObservables

import io.reactivex.Observable

fun main() {
    elementAt()
}

private fun elementAt() {
    Observable.just(1, 2, 3, 4, 5)
        .elementAt(1)
//        .elementAt(-1) // IndexOutOfBoundsException: index >= 0 required but it was -1
        .subscribe {
            println(it)
        }
}