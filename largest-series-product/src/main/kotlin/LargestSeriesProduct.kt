import java.lang.IllegalArgumentException
import java.util.Collections.max

class Series(private val input: String) {

    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        if (span > input.length) throw IllegalArgumentException("Incorrect values")
        if (span == 0 || input.isEmpty()) return 1

        return input.map { it.toString().toLong() }
                .windowed(span)
                .map { it.reduce { acc, l -> acc * l} }
                .max() ?: 0
    }
}
