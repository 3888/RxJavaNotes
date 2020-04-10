package baseClasses

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

fun main() {

    flowable()
        .subscribe({
            println("Flowable $it")
        },
            {
                println(it)

            }
        )
}

private fun flowable(): Flowable<Int> {
    return Flowable.create({ subscriber ->
        for (i in 0..10) {
            Thread.sleep(100)
            subscriber.onNext(i)
        }

        subscriber.onComplete()
    }, BackpressureStrategy.DROP)

}
