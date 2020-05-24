object Transpose {

    fun transpose(input: List<String>): List<String> {
        val result = mutableListOf<String>()
        input.forEachIndexed { i, it  ->
            it.forEachIndexed { index, c ->
                if (result.size<=index) result.add(index, "".padEnd(i,' ')+c)
                else result[index] = result[index].padEnd(i,' ')+c
            }
        }
        return result
    }
}