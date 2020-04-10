package rxkotlin

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main() {
        toObservable()
    observablesZipped()
}


    fun toObservable() {
        val list = listOf(1, 2, 3, 4, 0)
            .toObservable()
            .subscribeBy(
                {
                    it.printStackTrace()
                },
                {
                    println("onComplete!")
                },
                {
                    println(it.div(it))
                }
            )
    }

    fun observablesZipped() {
        val numbers = Observable.range(1, 6)
        val strings = Observable.just(
            "One", "Two", "Three","Four", "Five", "Six")

        val zipped = Observables.zip(strings, numbers) { s, n -> "zipped $s $n" }
        zipped.subscribe(::println)
    }
