import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow


object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val binary = number.toString(2)
        val lengthBinary = binary.length
        val signals: MutableList<Signal> = ArrayList()
        for (i in lengthBinary - 1 downTo 0){
            if (binary[i] == '1'){
                when (1 * 10.0.pow((lengthBinary - 1) - i).toInt()) {
                    1 -> signals.add(Signal.WINK)
                    10 -> signals.add(Signal.DOUBLE_BLINK)
                    100 -> signals.add(Signal.CLOSE_YOUR_EYES)
                    1000 -> signals.add(Signal.JUMP)
                    10000 -> signals.reverse()
                }
            }
        }
        return signals.toList()
    }
}