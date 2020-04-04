fun main() {

    val operators = OperatorsOfTransformations()
//    operators.filter()
//    operators.map()
//    operators.concat()
//    operators.distinct()
//    operators.distinctUntilChanged()

    val baseClasses = BaseClasses()

//    baseClasses.flowable()
//        .subscribe({
//                        println("Flowable $it")
//        },
//            {
//                println(it)
//            }
//        )

//    baseClasses.single()
//        .subscribe(
//            {
                //                for (i in it) {
//                    println("Single ${i.javaClass.typeName}")
//                }
//                println("Single ${it.size}")
//                throw Exception("Hi There!")
//            },
//            {
//                                println(it)
//            }
//        )

//    baseClasses.completable()
//        .subscribe({
//            println("All done")
//        },
//            {
//                println(it)
//            })

//    baseClasses.maybe(listOf(false, true))
//        .subscribe({
//            println("maybe $it onSuccess")
//        }, {
//            println(it)
//        },
//            {
//                println("maybe OnComplete")
//            })

//  baseClasses.disposableInterval(1000,  5000)

    val rxKotlin = RxKotlin()

//    rxKotlin.toObservable()
    rxKotlin.observablesZipped()

}