object Acronym {
    fun generate(phrase: String): String {
        val regex = Regex("[_, -]")
        return if (phrase.isNotEmpty()) {
            phrase.split(regex).filter { it.isNotEmpty() }
                    .joinToString("", "", "") { it.substring(0, 1).toUpperCase() }
        } else ""
    }
}
