import kotlin.math.abs
import kotlin.math.pow

object Wordy {
    private val operatorSet = setOf("plus", "minus", "multiplied", "divided", "raised")

    private fun solutionWithOperator(operator: String, value1: Int, value2: Int): Int =
            when (operator) {
                operatorSet.elementAt(0) -> (value1) + (value2)
                operatorSet.elementAt(1) -> value1 - value2
                operatorSet.elementAt(2) -> value1 * value2
                operatorSet.elementAt(3) -> value1 / value2
                operatorSet.elementAt(4) -> value1.toDouble().pow(value2.toDouble()).toInt()
                else -> throw IllegalArgumentException("Unsupported operations")
            }

    fun answer(input: String): Int {
        var value1 = 0
        var value2 = 0
        var operator = ""
        var count = 2
        val listCondition = input.split(" ").toMutableList()
                .filter { it != "by" }.map { it.dropLastWhile { it == '?' } }

        println(listCondition)
        if (listCondition[0].plus(" " + listCondition[1]) != "What is")
            throw IllegalArgumentException("Non-math questions")

        if (listCondition.size == 3) return listCondition[count].toInt()

        if (listCondition[count].toInt() >= 0
                || listCondition[count].toInt() <= 0) {
            value1 = listCondition[count].toInt()
            count++
        }

        if (count <= listCondition.size && operatorSet.contains(listCondition[count])) {
            operator = listCondition[count]
            count++
        } else throw IllegalArgumentException("Word problems with invalid syntax")

        if (operator == "raised") {
            value2 = listCondition[count + 2].filter { it.isDigit() }.toInt()
            count = listCondition.size + 1
        } else if (listCondition[count].toInt() > 0 ||
                listCondition[count].toInt() < 0
                && count <= listCondition.size) {
            value2 = listCondition[count].toInt()
            count++
        } else throw IllegalArgumentException("Word problems with invalid syntax")

        if (listCondition.size > count &&
                listCondition[count].first().isDigit())
            throw IllegalArgumentException("Word problems with invalid syntax")

        value1 = if (value1 < 0 && value2 < 0) solutionWithOperator(operator, value1, value2)
        else solutionWithOperator(operator, value1, value2)

        if (listCondition.size <= count) return value1

        if (listCondition.size > count + 1) {
            operator = listCondition[count]
            value2 = listCondition[count + 1].toInt()
            value1 = solutionWithOperator(operator, value1, value2)
        }
        return value1
    }
}
