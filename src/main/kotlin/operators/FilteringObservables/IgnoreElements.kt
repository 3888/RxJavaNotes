package operators.FilteringObservables

import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.atomic.AtomicInteger


fun main() {
    ignoreElements()
}

private fun ignoreElements() {
/*
Есть операторы, возвращающие Completable. Так что если вас не интересуют данные, и вы просто ждёте завершения или ошибки,
то можно использовать оператор ignoreElements.
 */

    /*
    https://mindorks.com/android/store/Reactive-Programming/reactivex/rxjava
    */
    val count = AtomicInteger()

    Observable.
    range(1, 10)
        .doOnNext { count.incrementAndGet() }
        .ignoreElements()
        .andThen(Single.fromCallable { count.get() })
        .subscribe({
            println(it)
        }, {
            println("Error $it")
        })
}



