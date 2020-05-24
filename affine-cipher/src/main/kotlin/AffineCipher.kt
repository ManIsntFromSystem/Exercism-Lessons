object AffineCipher {

    private val abc = 26
    private val symbols = 'a'..'z'
    private val digits = 0..25
    private val symKeys = symbols.zip(digits).toMap()
    private val digKey = digits.zip(symbols).toMap()

    fun encode(input: String, a: Int, b: Int): String {
        if (a % 2 == 0 || a % 13 == 0) throw IllegalArgumentException("Incorrect value")
        return input
                .filter { it.isLetterOrDigit() }
                .map { it.toLowerCase() }
                .map {
                    if (it.isLetter())
                        digKey[(symKeys.getValue(it) * a + b) % abc] else it
                }
                .joinToString("")
                .chunked(5)
                .joinToString(" ")
    }

    fun decode(input: String, a: Int, b: Int): String {
        if (a % 2 == 0 || a % 13 == 0) throw IllegalArgumentException("Incorrect value")
        return input
                .replace(" ", "")
                .map {
                    if (it.isLetter())
                        digKey[(myInv(a) * myRes(symKeys.getValue(it) - b))
                                % abc] else it
                }
                .joinToString("")
    }

    private fun myInv(a: Int): Int {
        for (i in 0..abc)
            if ((i * a) % abc == 1) return i
        return -1
    }
}

tailrec fun myRes(value: Int): Int = when {
    value > 0 -> value
    else -> myRes(value + 26)
}



