package operators.filtering

import io.reactivex.Observable
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit


fun main() {
    debounce(500)
}

private fun debounce(pauseInMillis: Long) {
/*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#0e83
*/
    Observable.just(1, 2, 3, 4, 5)
        .map {
            println(it)
            Thread.sleep(pauseInMillis)
        }
        .debounce(pauseInMillis, TimeUnit.MILLISECONDS)
        .subscribe {
            println(LocalDateTime.now())
        }
}