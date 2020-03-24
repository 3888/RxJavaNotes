import io.reactivex.rxjava3.core.*

class BaseClasses {

    fun flowable(): Flowable<Int> {
        return Flowable.create({ subscriber ->
            for (i in 0..10) {
                Thread.sleep(100)
                subscriber.onNext(i)
            }

            subscriber.onComplete()
        }, BackpressureStrategy.DROP)

    }


    fun single(): Single<List<Any>> {
        return Single.create { subscriber ->
            subscriber.onSuccess(listOf("String", 1, 0F, 0L))
        }
    }

    fun completable(): Completable {
        return Completable.create { subscriber ->
            for (i in listOf(2, 4, 0)) {
                println("4 / $i = ${4 / i}")
            }
            subscriber.onComplete()
        }
    }

    fun maybe(list: List<Boolean>): Maybe<Any> {
        return Maybe.create { subscriber ->

            for (i in list) {
                if (!i) {
                    subscriber.onComplete()
                }
            }
        }
    }
}