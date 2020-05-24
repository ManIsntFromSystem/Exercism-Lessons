import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.TWO

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64) {"Incorrect value"}
        var count: Long = 1
        for (i in 1 until number) count *= 2
        return count.toBigInteger().abs()
    }

    fun getTotalGrainCount(): BigInteger =
            (getGrainCountForSquare(64) * TWO) - ONE
}
