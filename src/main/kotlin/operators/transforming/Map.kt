package operators.transforming

import io.reactivex.Observable
import io.reactivex.Single
import kotlin.random.Random

fun main() {

//    map()
//    mapInRange()
//    mapError()

    mapSingleBoolean()
        .subscribe(
            {
                if (it) {
                    println("The value is lower")
                } else {
                    println("The value is higher")
                }
            },
            {
                println(it)
            }
        )

}

private fun map() {
    Observable.just(1, 2, 3)
        .map { x -> x * 10 }
        .subscribe {
            println("map item: $it")
        }
}

private fun mapInRange() {
    Observable.just(
        Random.nextInt(10, 70),
        Random.nextInt(10, 70),
        Random.nextInt(10, 70),
        Random.nextInt(10, 70)
    )
        .map {
            println("Temperature is $it degrees Celsius")
            when (it) {
                in 41..70 -> {
                    println("It's too hot")
                }
                in 20..40 -> {
                    println("All fine")
                }
                in 10..19 -> {
                    println("It's cold")
                }
            }
        }
        .subscribe()
}

private fun mapError() {
    /*ClassCastException thrown here.*/
    val a: Any = 0F
    val b = 0.0
    val c: Any = ""

    Observable.just(a, b, c)
        .map { x -> x as Long }
        .subscribe({
            println("map item: $it")
        }, {
            println(it)
        })
}

private fun mapSingleBoolean(): Single<Boolean> {
    val until = 10
    val value = 5

    return Single.create<Int> {
        it.onSuccess(
            Random.nextInt(until)
        )
    }
        .map {
            println("$it < $value ${it < value}")
            it < value
        }
}




