import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject


class OperatorsOfTransformations {
    /*
    https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5
     */

    fun filter() {
        Observable.just(2, 30, 22, 5, 60, 1)
            .filter { x -> x > 10 }
            .subscribe {
                println("filter item: $it")
            }
    }

    fun map() {
        Observable.just(1, 2, 3)
            .map { x -> x * 10 }
            .subscribe {
                println("map item: $it")
            }
    }


    fun concat() {
        val first = Observable.just(1, 2, 3)
        val second = Observable.just(4, 5, 6)

        Observable.concat(first, second)
            .subscribe {
                println("concat item: $it")
            }

    }

    fun zipBiFunction(name: String, age: Int) {
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

    fun combineLatestBiFunction(name: String, age: Int) {
        /*
        https://dev.to/amay077/rxjava-combinelatest-quick-example-e8b
        * */
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

    fun distinct() {
        Observable.just(1, 2, 2, 1, 3, 1, 2)
            .distinct()
            .subscribe {
                println("distinct item: $it")
            }
    }

    fun distinctUntilChanged() {
        Observable.just(1, 2, 2, 3, 3, 4, 4, 1, 5, 2)
            .distinctUntilChanged()
            .subscribe {
                println("distinctUntilChanged item: $it")
            }
    }

    /*
    Порядок, в котором объединяются наблюдаемые, не гарантируется таким же, как в исходном Observable
    */

    fun flatMap() {

    }

    fun flatMapSingle(value: Int): Single<Boolean> =
        Single.just(value)
            .flatMap {
                println("$it <= 5")
                if (value <= 5) {
                    Single.fromCallable {
                        println(it <= 5)
                        true
                    }
                } else {
                    Single.fromCallable {
                        println(it <= 5)
                        false
                    }
                }
            }


}