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

    fun distinct (){
        Observable.just(1, 2, 2, 1, 3,1,2)
            .distinct()
            .subscribe{
                println("distinct item: $it")
            }
    }

    fun distinctUntilChanged (){
        Observable.just(1, 2, 2, 3, 3,4,4,1,5,2)
            .distinctUntilChanged()
            .subscribe{
                println("distinctUntilChanged item: $it")
            }
    }

}