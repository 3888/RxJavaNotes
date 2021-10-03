package baseClasses

import io.reactivex.Completable

fun main() {

//    andThenBranch()
//        .subscribe({
//            println("All done")
//        },
//            {
//                println(it)
//            })

//    checkFilePathAndDelete(null)
//        .subscribe({
//            println("File deleted")
//        },
//            {
//                println(it)
//            })

    curlyAndRoundBracketsForAndThen()

}

private fun curlyAndRoundBracketsForAndThen() {
    dividing()
        .andThen(dividingWithError())
//        .andThen { dividingWithError() }
//        .andThen(dividing())
//        .andThen {
//            dividing()
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

private fun andThenBranch(): Completable {
    return completable(3000, 1)
        .andThen(completable(2000, 2))
        .andThen(completable(1000, 3))
}

private fun dividingWithError(): Completable {
    return Completable
        .create { subscriber ->
            for (i in listOf(0)) {
                println("4 / $i = ${4 / i}")
            }
            subscriber.onComplete()
        }
}

private fun dividing(): Completable {
    return Completable
        .create { subscriber ->
            for (i in listOf(2, 4, 1)) {
                println("4 / $i = ${4 / i}")
            }
            subscriber.onComplete()
        }
}

fun checkFilePathAndDelete(path: String?): Completable {
    return when {
        path == null -> Completable.error(Throwable("path is null"))
        path.isEmpty() -> Completable.error(Throwable("path is Empty"))
        path.isBlank() -> Completable.error(Throwable("path is Blank"))
        else -> Completable.complete()
    }
}

private fun completable(millis: Long, number: Int): Completable {
    return Completable
        .fromCallable {
            Thread.sleep(millis)
            println("Message number $number after $millis sleep")
        }

}


