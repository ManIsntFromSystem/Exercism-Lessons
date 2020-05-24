import java.awt.SystemColor.text
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt


object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        if (plaintext.isEmpty()) return plaintext

        val text = StringBuilder().append(plaintext.filter { it.isDigit() || it.isLetter() }
                .toLowerCase())
        var size = 0
        for (i in text) ++size

        if (size < 2) return text.toString()

        val c = ceil(sqrt(size.toDouble())).toInt()

        //while((r * c - size) > 0) text.append(' ')
        while (size % c != 0) {
            text.append(' ')
            ++size
        }

        val str = StringBuilder()
        for (i in 0 until c) {
            var pos = i
            while (pos < size) {
                str.append(text[pos])
                pos += c
            }
            if (str.length < size)str.append(' ')
        }
        return str.toString()
    }
}
