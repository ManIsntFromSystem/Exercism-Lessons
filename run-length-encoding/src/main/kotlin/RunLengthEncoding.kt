object RunLengthEncoding {

    fun encode(input: String): String {
        val encodedString = StringBuilder()
        var count = 1
        for (i in input.indices) {
            if (i + 1 < input.length && input[i] == input[i + 1])
                ++count;
            else {
                if (count > 1) encodedString.append(count.toString())
                encodedString.append(input[i].toString());
                count = 1;
            }
        }
        return encodedString.toString()
    }

    fun decode(input: String): String {
        val dictionary = mutableListOf('⌂', 'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', 'Æ', 'È','É')
        val encodedString = StringBuilder()
        var i = 0

        while (i in input.indices) {
            val times = input.substring(i).takeWhile { it.isDigit() }
            val count = times.count()
            val index = dictionary.indexOf(input[i + count])
            val char = if (index != -1) '0' + index else input[i + count]
            repeat(times.toIntOrNull() ?: 1) {encodedString.append(char)}
            i += 1 + count
        }
        return encodedString.toString()
    }
}
