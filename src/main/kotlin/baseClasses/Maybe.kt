package baseClasses

import io.reactivex.Maybe


fun main() {

//    maybe(listOf(false, true))
//        .subscribe({
//            println("maybe $it onSuccess")
//        }, {
//            println(it)
//        },
//            {
//                println("maybe OnComplete")
//            })

    getPath()

}


private fun maybe(list: List<Boolean>): Maybe<List<Boolean>> {
    return Maybe.create { subscriber ->
        for (i in list) {
            if (i) {
                subscriber.onComplete()
            } else {
                subscriber.onSuccess(list)
            }
        }
    }
}

private fun getPath() =
    Maybe.fromCallable {
        null
    }
//        .flatMapCompletable {
//            println(it)
//            Completable.complete()
//        }
        .subscribe(
            {
                    println("onSuccess")
            },
            {
                println("onError")
            },
            {
                println("onComplete")
            }
        )


