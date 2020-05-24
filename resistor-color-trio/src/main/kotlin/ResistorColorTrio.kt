import kotlin.math.pow

object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val value = (10 * input[0].ordinal) + input[1].ordinal
        val exp = input[2].ordinal
        var total = value * 10.toDouble().pow(exp)
        var count = 0
        while (total > 999) {
            total /= 1000
            count++
        }
        return total.toInt().toString() +
                " "+ Unit.values()[count].name.toLowerCase()
    }
}
