object Pangram {

    fun isPangram(input: String): Boolean {
        var charArr = ('a'..'z').toMutableList()
        for (char in input.toLowerCase().toCharArray()){
            if (charArr.contains(char))
                charArr.remove(char)
        }
        return charArr.size == 0
    }
}
