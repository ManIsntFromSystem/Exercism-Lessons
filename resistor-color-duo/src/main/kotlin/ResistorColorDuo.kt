object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        val value1 = colors[0].name
        val value2 = colors[1].name
        return "${Color.valueOf(value1).ordinal}${Color.valueOf(value2).ordinal}".toInt()
    }
}
