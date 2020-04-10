package baseClasses

import io.reactivex.Completable

fun main() {

    completable()
        .subscribe({
            println("All done")
        },
            {
                println(it)
            })

}

private fun completable(): Completable {
    return Completable.create { subscriber ->
        for (i in listOf(2, 4, 0)) {
            println("4 / $i = ${4 / i}")
        }
        subscriber.onComplete()
    }
}
