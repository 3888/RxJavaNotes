import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main() {
//    defaultThreadingInRxJava()
//    backgroundThread()
//    subscribeOnOnly()
//    observeOnOnly()
    switchThreadByObserveOn()
}

/*
https://proandroiddev.com/understanding-rxjava-subscribeon-and-observeon-744b0c6a41ea
*/
private fun defaultThreadingInRxJava() {
    Observable.just("long", "longer", "longest")
        .doOnNext {
            println("processing item ***$it*** on thread " + Thread.currentThread().name)
        }
        .map(String::length)
        .filter { it > 6 }
        .subscribe { length ->
            println("item length $length")
        }
}

private fun backgroundThread() {
    Observable.just("long", "longer", "longest")
        .doOnNext {
            println("processing item ***$it*** on thread " + Thread.currentThread().name)
        }
        .subscribeOn(Schedulers.io())
        .map(String::length)
        .subscribe { length ->
            println("item length $length on thread" + Thread.currentThread().name)
        }
    Thread.sleep(1000)
}

private fun subscribeOnOnly() {
    /*
    If only subscribeOn is specified, all operators will be be executed on that thread
    */
    Observable.just("long", "longer", "longest")
        .map(String::length)
        .filter { it > 6 }
        .subscribeOn(Schedulers.io())
        .subscribe { length ->
            println("item length $length on thread" + Thread.currentThread().name)
        }

    Thread.sleep(1000)
}

private fun observeOnOnly() {
    Observable.just("long", "longer", "longest")
        .map(String::length)
        .filter { it > 6 }
        .observeOn(Schedulers.io())
        .subscribe { length ->
            println("item length $length on thread" + Thread.currentThread().name)
        }
    Thread.sleep(1000)
}

private fun switchThreadByObserveOn() {
    Observable.just("long", "longer", "longest")
        .doOnNext {
            println(
                "processing item on thread " + Thread.currentThread().name
            )
        }
        .subscribeOn(Schedulers.newThread())
        .map { obj: String -> obj.length }
        .observeOn(Schedulers.computation())
        .subscribe { length: Int ->
            println(
                "item length " + length + " received on thread " + Thread.currentThread().name
            )
        }
    Thread.sleep(1000)
}