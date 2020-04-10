package baseClasses

import io.reactivex.Single

fun main() {

    single()
        .subscribe(
            {
                for (i in it) {
                    println("Single ${i.javaClass.typeName}")
                }
                println("Single ${it.size}")
                throw Exception("Hi There!")
            },
            {
                println(it)
            }
        )


}

private fun single(): Single<List<Any>> {
    return Single.create { subscriber ->
        subscriber.onSuccess(listOf("String", 1, 0F, 0L))
    }
}