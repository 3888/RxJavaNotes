import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

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


    fun single(): Single<List<Int>> {
        return Single.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7)
            subscriber.onSuccess(list)
        }
    }

}