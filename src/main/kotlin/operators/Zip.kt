package operators

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

fun main() {

}


private fun zipBiFunction(name: String, age: Int) {
    val nameSubject = PublishSubject.create<String>()
    val ageSubject = PublishSubject.create<Int>()

    Observable.zip<String, Int, String>(
        nameSubject, ageSubject, BiFunction { n, a -> "name is $n - age is $a" })
        .subscribe {
            println("onNext - $it")
        }

    nameSubject.onNext(name)
    ageSubject.onNext(age)
}