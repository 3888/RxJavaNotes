package operators.transforming

import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream


/*
https://www.techiedelight.com/difference-map-flatmap-java/
https://ru.stackoverflow.com/questions/946216/%D0%92-%D1%87%D0%B5%D0%BC-%D1%80%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC%D0%B8-map-%D0%B8-flatmap-%D0%B2-java-8
https://overcoder.net/q/2085/%D0%B2-%D1%87%D0%B5%D0%BC-%D1%80%D0%B0%D0%B7%D0%BD%D0%B8%D1%86%D0%B0-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC%D0%B8-map-%D0%B8-flatmap-%D0%B2-java-8
*/
fun main() {
//    flatMap()
    convertStringToUpperCaseStreams()

}

private fun flatMap() {
    val a = listOf(1, 2, 3)
    val b = listOf(4, 5)
    val c = listOf(6, 7, 8)
    val listOfListOfInts =
        Arrays.asList(a, b, c)
    println("Before flattening : $listOfListOfInts")
    val listOfInts = listOfListOfInts.stream()
        .flatMap { list: List<Int> -> list.stream() } // or use List::stream
        .collect(Collectors.toList())
    println("After flattening : $listOfInts")
}


fun convertStringToUpperCaseStreams() {
    val collected =
        Stream.of("a", "b", "hello") // Stream of String
            .map { obj: String -> obj.toUpperCase() } // Returns a stream consisting of the results of applying the given function to the elements of this stream.
            .collect(Collectors.toList())

    println(collected)
}



