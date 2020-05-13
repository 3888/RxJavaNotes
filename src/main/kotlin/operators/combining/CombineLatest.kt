package operators.combining

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.functions.BiFunction


/*
https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5#d30a
*/

fun main() {

}

private fun combineLatestBiFunction(name: String, age: Int) {
    /*
    https://dev.to/amay077/rxjava-combinelatest-quick-example-e8b
     */
    val nameSubject = PublishSubject.create<String>()
    val ageSubject = PublishSubject.create<Int>()

    Observable.combineLatest<String, Int, String>(
        nameSubject, ageSubject, BiFunction { n, a -> "name is $n - age is $a" })
        .subscribe {
            println("onNext - $it")
        }

    nameSubject.onNext(name)
    ageSubject.onNext(age)
    nameSubject.onNext("New name")
}