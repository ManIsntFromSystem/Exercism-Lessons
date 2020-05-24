object Atbash {

    val list = generateSequence('a') {it + 1}
            .take(('a'..'z').count()).toList()
    val encodeMap = list.zip(list.reversed()).toMap()
    val decodeMap = list.reversed().zip(list).toMap()

    fun encode(s: String) = convert(s, encodeMap)
            .windowed(5, 5, true)
            .joinToString(" ")
    fun decode(s: String) = convert(s, decodeMap)

    private fun convert(str: String, map: Map<Char, Char>): String = str
            .filter { it.isLetterOrDigit() }
            .map { it.toLowerCase() }
            .map { map.getOrDefault(it, it) }
            .joinToString("")
}
