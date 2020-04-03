import io.reactivex.rxjava3.core.*
import java.util.concurrent.TimeUnit

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

    fun maybe(list: List<Boolean>): Maybe<List<Boolean>> {
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

    fun disposableInterval(intervalPeriodMillis: Long, sleepDelayMillis: Long) {
        val seconds = Observable.interval(intervalPeriodMillis, TimeUnit.MILLISECONDS)
        val disposable = seconds
            .subscribe { l -> println("Received: " + l!!) }

        //sleep 5 seconds
        Thread.sleep(sleepDelayMillis)

        disposable.dispose()

        if (disposable.isDisposed) {
            println("Disposable is disposed!")
        }
    }
}