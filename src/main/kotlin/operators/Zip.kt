package operators

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

fun main() {

    zipBiFunction("Tony", 100)
}


private fun zipBiFunction(name: String, age: Int) {
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