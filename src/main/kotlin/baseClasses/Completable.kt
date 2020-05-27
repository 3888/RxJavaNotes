package baseClasses

import io.reactivex.Completable

fun main() {

    doOnComplete()
//        .andThen(doOnError())
//        .andThen { doOnError() }
        .andThen(doOnComplete())
//        .andThen {
//            doOnComplete()
//            .subscribe({
//                println("All done now HERE!")
//            },
//                {
//                    println(it)
//                })
//        }
        .subscribe({
            println("All done")
        },
            {
                println(it)
            })

//    doOnError()
//        .andThen(doOnComplete())
////        .andThen { doOnComplete() }
//        //        .andThen(doOnError())
////        .andThen { doOnError() }
//        .subscribe({
//            println("All done")
//        },
//            {
//                println(it)
//            })

}

private fun doOnError(): Completable {
    return Completable
        .create { subscriber ->
            for (i in listOf(2, 4, 0)) {
                println("4 / $i = ${4 / i}")
            }
            subscriber.onComplete()
        }
}

private fun doOnComplete(): Completable {
    return Completable
        .create { subscriber ->
            for (i in listOf(2, 4, 1)) {
                println("4 / $i = ${4 / i}")
            }
            subscriber.onComplete()
        }
}