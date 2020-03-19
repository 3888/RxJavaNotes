import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable

fun main() {

    Flowable.just("Hello world").subscribe(System.out::println)

    Observable.just(2, 30, 22, 5, 60, 1)
        .filter { x -> x > 10}
        .subscribe {
         println("item: $it" )
        }


}