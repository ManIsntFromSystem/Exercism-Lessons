data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val saddle: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate> = result()

    private fun result(): Set<MatrixCoordinate> {
        val result = mutableSetOf<MatrixCoordinate>()

        fun getSaddleIndexes(row: List<Int>, value: Int) =
            row.mapIndexedNotNull { index, item -> if (item == value) index else null }

        saddle.forEachIndexed { rowIndex, row ->
            val maxRowValue = row.max() ?: return@forEachIndexed

            val saddleRowIndexes = getSaddleIndexes(row, maxRowValue)

            saddleRowIndexes
                .map { saddleRowIndex ->
                    saddleRowIndex to saddle.map { it[saddleRowIndex] }
                }
                .forEach { column ->
                    val minColumnValue = column.second.min()!!

                    if (maxRowValue == minColumnValue) MatrixCoordinate(
                        row = rowIndex + 1,
                        col = column.first + 1
                    ).let(result::add)
                }
        }
        return result
    }
}
