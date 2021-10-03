package operators

import io.reactivex.Observable
import kotlin.random.Random

fun performLongOperation(value: String): Observable<String> {
    val millis = Random.nextInt(1, 10) * 100L
    println("sleep for $millis")

    Thread.sleep(millis)
    return Observable.just(value)
}