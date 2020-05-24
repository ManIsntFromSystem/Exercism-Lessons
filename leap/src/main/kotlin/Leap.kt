data class Year(val year: Int) {

    val isLeap: Boolean = isALeapYear()

    private fun isALeapYear() = when {
        year % 400 == 0 -> true
        year % 4 == 0 && year % 100 != 0 -> true
        else -> false
    }
}
