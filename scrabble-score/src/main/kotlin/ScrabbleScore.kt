object ScrabbleScore {

    fun scoreWord(input: String) = input.sumBy {
        when (it.toUpperCase()) {
            'Q', 'Z' -> 10
            'J', 'X' -> 8
            'K' -> 5
            'F', 'H', 'V', 'W', 'Y' -> 4
            'B', 'C', 'M', 'P' -> 3
            'D', 'G' -> 2
            else -> 1
        }
    }
}
