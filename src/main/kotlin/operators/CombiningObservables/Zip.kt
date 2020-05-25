package operators.CombiningObservables

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

fun main() {
//    zipBiFunctionPublisher("Tony", 100)
    zipBiFunction()
}


private fun zipBiFunctionPublisher(name: String, age: Int) {
    val nameSubject = PublishSubject.create<String>()
    val ageSubject = PublishSubject.create<Int>()
    Observable.zip<String, Int, String>(
        nameSubject, ageSubject, BiFunction { n, a -> "name is $n - age is $a" })
        .subscribe {
            println(it)
        }

    nameSubject.onNext(name)
    ageSubject.onNext(age)
}

private fun zipBiFunction() {
    val chars = Observable.just("A", "B", "C", "D", "NO PAIR FOR THIS VALUE")
    val numbers = Observable.just(1, 2, 3, 4)
    Observable.zip<String, Any, String>(
        chars, numbers
        , BiFunction { n, a -> "$n $a" })
        .subscribe {
            println(it)
        }
}