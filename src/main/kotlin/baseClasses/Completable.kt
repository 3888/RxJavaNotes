package baseClasses

import io.reactivex.Completable
import io.reactivex.Maybe

fun main() {

    deleteFile()
        .subscribe({
            println("All done")
        },
            {
                println(it)
            })

}

private fun curlyAndRoundBracketsForAndThen() {
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

private fun deleteFile(): Completable {
    val path: String? = null

    return Maybe.fromCallable {
        path
    }
        .flatMapCompletable {
            if (it.isEmpty()) println("isEmpty")
            if (it.isBlank()) println("isBlank")

            Completable.complete()
        }
}


