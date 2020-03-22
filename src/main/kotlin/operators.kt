import io.reactivex.rxjava3.core.Observable

class operators {
    /*
    https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5
     */

    fun filter() {
        Observable.just(2, 30, 22, 5, 60, 1)
            .filter { x -> x > 10 }
            .subscribe {
                println("filter item: $it")
            }
    }

    fun map() {
        Observable.just(1, 2, 3)
            .map { x -> x * 10 }
            .subscribe {
                println("map item: $it")
            }
    }


    fun concat() {
        val first = Observable.just(1, 2, 3)
        val second = Observable.just(4, 5, 6)

        Observable.concat(first,second)
            .subscribe{
                println("concat item: $it")
            }

    }


}