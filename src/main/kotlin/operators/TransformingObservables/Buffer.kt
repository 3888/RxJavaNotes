package operators.TransformingObservables

import io.reactivex.Observable

fun main() {
    buffer()
}

private fun buffer() {
    Observable.just("First", "Second", "Third", "Four", "Fifth", " Sixth")
        .buffer(2)
        .subscribe {
            println("buffer item: $it")
        }
}