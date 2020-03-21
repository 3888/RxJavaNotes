fun main() {

    val operators = operators()

    operators.filter()

    operators.map()

    val exampleFlowable = BaseClasses()

    exampleFlowable.flowable()
        .subscribe({
            println("Flowable $it")
        },
            {
                println(it)
            }
        )


    val exampleSingle = BaseClasses()

    exampleSingle.single()
        .subscribe({
            println("Single $it")
        },
            {
                println(it)
            }
        )
}