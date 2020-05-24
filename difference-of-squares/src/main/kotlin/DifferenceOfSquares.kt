import kotlin.math.pow

class Squares(private var value: Int) {

    fun squareOfSum(): Int {
        var count = 1
        var sum = 0
        repeat((1..value).count()) {
            sum += count
            count++
        }
        return sum.toDouble().pow(2.0).toInt()
    }

    fun sumOfSquares(): Int {
        var sum = 0
        for (i in 1..value)
            sum+=i.toDouble().pow(2).toInt()
        return sum
    }

    fun difference() = squareOfSum() - sumOfSquares()
}
