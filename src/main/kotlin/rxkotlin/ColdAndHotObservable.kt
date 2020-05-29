package rxkotlin

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


fun main() {
    coldObservable()
}

private fun coldObservable() {
    Observable.just("long", "longer", "longest")
        .doOnNext { println("processing item on thread " + Thread.currentThread().name) }
        .subscribeOn(Schedulers.newThread())
        .map {
            it.length
        }
        .subscribe { println("item length $it") }

    Thread.sleep(1000)
}