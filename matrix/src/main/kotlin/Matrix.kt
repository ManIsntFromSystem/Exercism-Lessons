import java.util.*
import java.util.function.ToIntFunction
import java.util.stream.Collectors


class Matrix(private val matrixAsString: String) {
    private val matrix = matrixAsString.split("\n")
            .map(this::convertStringToAListOfNumbers)

    fun column(colNr: Int): List<Int> {
            return matrix.map{ rows -> rows[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrix[rowNr - 1]
    }

    private fun convertStringToAListOfNumbers(rowAsString: String): List<Int> {
        return rowAsString.split(" ")
                .map { it.trim() }
                .filter { Regex("[0-9]+").containsMatchIn(it) }.toTypedArray()
                .map { it.toInt() }
    }
}
