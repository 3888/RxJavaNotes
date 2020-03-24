fun main() {

    val operators = operators()
//    operators.filter()
//    operators.map()
//    operators.concat()
//    operators.distinct()
//    operators.distinctUntilChanged()

    val baseClasses = BaseClasses()

    baseClasses.flowable()
        .subscribe({
            //            println("Flowable $it")
        },
            {
                println(it)
            }
        )

    baseClasses.single()
        .subscribe(
            {
                for (i in it) {
//                    println("Single ${i.javaClass.typeName}")
                }
//                println("Single ${it.size}")
            },
            {
                println(it)
            }
        )

//    baseClasses.completable()
//        .subscribe({
//            println("All done")
//        },
//            {
//                                println(it)
//            })

}