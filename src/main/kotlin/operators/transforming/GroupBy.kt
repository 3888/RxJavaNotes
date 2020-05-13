package operators.transforming

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.observables.GroupedObservable

fun main() {
    groupByBoolean()
}

private fun groupByBoolean() {
    val validKeys: MutableList<String> = ArrayList()
    val invalidKeys: MutableList<String> = ArrayList()

    val subscribe = Observable.just(
        "1*1057001", "01*1572", "0065416103",
        "00000771", "1*144432", "14431313"
    )
        .groupBy { t ->
            t.contains("1*1")
        }
        .subscribe(
            object : Observer<GroupedObservable<Boolean, String>> {
                override fun onNext(groupedObservable: GroupedObservable<Boolean, String>) {
                    if (groupedObservable.key == true) {
                        groupedObservable.subscribe({
                            validKeys.add(it)
                        }, {
                            println("Error: $it")
                        })
                    } else {
                        groupedObservable.subscribe({
                            invalidKeys.add(it)
                        }, {
                            println("Error: $it")
                        })
                    }
                }

                override fun onComplete() {
                    println("Valid keys: $validKeys")
                    println("Invalid keys: $invalidKeys")
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    println("Error: $e")
                }
            }
        )
}

