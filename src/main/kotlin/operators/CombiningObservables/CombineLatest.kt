package operators.CombiningObservables

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.Observables
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


/*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#d30a
*/

fun main() {

//    combineLatest()
//    combineLatestPublishSubject()
//    combineLatestInterval(200, 400)
    temperature()

}

private fun combineLatest() {
    val observable1 = Observable.range(1, 10)
    val observable2 = Observable.just("A", "B", "C", "D")

    Observable
        .combineLatest(
            observable1,
            observable2,
            object : BiFunction<Int, String, String> {
                override fun apply(t1: Int, t2: String): String {
                    return "observable1 value: $t1 , observable2 value: $t2 "
                }
            })
        .subscribe(object : Observer<String> {
            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext: $t")
            }

            override fun onError(e: Throwable) {

            }

        })
}

/*
https://dev.to/amay077/rxjava-combinelatest-quick-example-e8b
 */
private fun combineLatestPublishSubject() {
    val name = PublishSubject.create<String>()
    val age = PublishSubject.create<Int>()

// Can not omit Type parameters and BiFunction
    Observable.combineLatest<String, Int, String>(
        name, age, BiFunction { n, a -> "$n - age:${a}" })
        .subscribe({
            println("onNext - ${it}")
        })

// If you introduce RxKotlin then you can use type inference
    Observables.combineLatest(name, age) { n, a -> "$n - age:${a}" }
        .subscribe({
            println("onNext - ${it}")
        })

// Also we can use Observable array for 1st parameter
// but second parameter to be array, it's not cool.
    Observable.combineLatest(arrayOf(name, age), {
        val n = it[0] as String
        val a = it[1] as Int
        "$n - age:${a}"
    })
        .subscribe({
            println("onNext - ${it}")
        })


    name.onNext("saito")
    age.onNext(24)
    name.onNext("yoshida")
}

private fun combineLatestInterval(firstInterval: Long, secondInterval: Long) {
    val observable1 = Observable.interval(firstInterval, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(secondInterval, TimeUnit.MILLISECONDS)

    Observable
        .combineLatest(
            observable1,
            observable2,
            object : BiFunction<Long, Long, String> {
                override fun apply(t1: Long, t2: Long): String {
                    return "observable1 value: $t1 firstInterval $firstInterval, observable2 value: $t2 secondInterval $secondInterval"
                }
            })
        .take(5)
        .subscribe(object : Observer<String> {
            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext: $t")
            }

            override fun onError(e: Throwable) {

            }

        })

    TimeUnit.SECONDS.sleep(1)
}

private fun temperature() {
    val firstRoom = Observable
//        .just(25, 15, 30, 27)
        .range(1, 10)
        .zipWith(Observable.interval(250, TimeUnit.MILLISECONDS), object : BiFunction<Int, Any, Int> {
            override fun apply(t1: Int, t2: Any): Int {
                return t1*-1
            }
        })

    val secondRoom = Observable
//        .just(-5, 0, -10, -3)
        .range(1, 10)
        .zipWith(Observable.interval(500, TimeUnit.MILLISECONDS), object : BiFunction<Int, Any, Int> {
            override fun apply(t1: Int, t2: Any): Int {
                return t1
            }
        })

    val test = Observable.combineLatest(firstRoom, secondRoom, object : BiFunction<Int, Int, Array<Int>> {
        override fun apply(t1: Int, t2: Int): Array<Int> {
            return arrayOf(t1, t2)
        }
    })
        .subscribe({
            println("first ${it[0]}  second ${it[1]}")
        }, {

        })

    TimeUnit.SECONDS.sleep(3)
}

