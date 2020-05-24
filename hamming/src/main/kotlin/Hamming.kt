import java.lang.IllegalArgumentException

object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        var countChangedGens = 0

        return if (leftStrand.length == rightStrand.length) {
            for (i in leftStrand.indices) {
                if (leftStrand[i] != rightStrand[i]) countChangedGens++
            }
            countChangedGens
        } else throw IllegalArgumentException("left and right strands must be of equal length")
    }
}
