package baseClasses

import io.reactivex.Maybe


fun main() {

    maybe(listOf(false, true))
        .subscribe({
            println("maybe $it onSuccess")
        }, {
            println(it)
        },
            {
                println("maybe OnComplete")
            })

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

