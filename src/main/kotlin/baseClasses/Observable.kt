package baseClasses

import io.reactivex.Observable

fun main() {
    observable()
}

private fun observable() {

    Observable.just("1", "2")
        .map {
            it + "0 just"
        }
        .doOnNext {
            println("$it doOnNext")
        }
        .doOnComplete { println("doOnComplete") }
        .subscribe {
            println("$it subscribe")
        }




    Observable.just("1", "2", "3")
        .map {
            it + "0 just"
        }
        .subscribe { it ->
            println(it)

        }

    Observable.just(listOf("1", "2", "3"))
        .map {
            it + "listOf"
        }
        .subscribe {
            println(it)
        }


    Observable.empty<String>()
        .map { empty ->
            empty + "0"
        }
        .subscribe {
            println(it)
        }


    Observable.fromIterable(listOf("1", "2", "3"))
        .map {
            it + " fromIterable"
        }
        .subscribe {
            println(it)
        }


    Observable.error<String> {
        Exception()
    }
        .doOnError {
            println("*************ERRROOORRRR************")
        }.subscribe {
            println(it)
        }


}



