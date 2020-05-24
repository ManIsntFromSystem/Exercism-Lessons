import kotlin.math.sin

object Luhn {

    fun isValid(candidate: String): Boolean {
        if (candidate.contains("[^0-9 ]".toRegex()) ||
                candidate.trim().length <= 1) return false

        val values = Regex("""\d""").findAll(candidate)
                .toList().map { it.value.toInt() }

        val result = mutableListOf<Int>()

        var count = values.size - 2
        for (i in values.size - 1 downTo 0) {
            result += when {
                i != count -> values[i]
                values[i] * 2 < 10 -> values[i] * 2
                else -> (values[i] * 2) - 9
            }
            if (count == i) count -= 2
        }

        println(result)
        return result.sum() % 10 == 0
    }
}