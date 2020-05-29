import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main() {
//    defaultThreadingInRxJava()
//    subscribeOnOnly()
//    observeOnOnly()
    wrongThread()
}


/*https://proandroiddev.com/understanding-rxjava-subscribeon-and-observeon-744b0c6a41eahttps://proandroiddev.com/understanding-rxjava-subscribeon-and-observeon-744b0c6a41ea*/
private fun defaultThreadingInRxJava() {
    Observable.just("long", "longer", "longest")
        .doOnNext {
            println("processing item on thread " + Thread.currentThread().name)
        }
        .map(String::length)
        .filter { it > 6 }
        .subscribe { length -> println("item length $length") }
}


private fun subscribeOnOnly() {
    Observable.just("long", "longer", "longest")
        .map(String::length)
        .filter { it > 6 }
        .subscribeOn(Schedulers.computation())
        .subscribe { length -> println("item length $length") }
}

private fun observeOnOnly() {
    Observable.just("long", "longer", "longest")
        .map(String::length)
        .filter { it > 6 }
        .observeOn(Schedulers.computation())
        .subscribe { length -> println("item length $length") }
}

private fun wrongThread(){
    Observable.just("long", "longer", "longest")
        .subscribeOn(Schedulers.io())
        .map(String::length)
        .observeOn(Schedulers.computation())
        .filter { it > 6 }
        .subscribe { length -> println("item length $length") }

}


