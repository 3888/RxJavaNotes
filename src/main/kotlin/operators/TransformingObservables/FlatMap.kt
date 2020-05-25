package operators.TransformingObservables

import io.reactivex.Single
import kotlin.random.Random

fun main() {

    flatMapSingle(Random.nextInt(10)).subscribe()

}

private fun flatMap() {
/*
Порядок, в котором объединяются наблюдаемые, не гарантируется таким же, как в исходном Observable
https://stackoverflow.com/questions/53682216/rxjava-schedulers-io-doesnt-work-in-maven-project
 */
}

private fun flatMapSingle(value: Int): Single<Boolean> =
    Single.just(value)
        .flatMap {
            println("$it < 5")
            if (value < 5) {
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

