package operators

import io.reactivex.Single

fun main() {

/*
Порядок, в котором объединяются наблюдаемые, не гарантируется таким же, как в исходном Observable
 */


}

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

