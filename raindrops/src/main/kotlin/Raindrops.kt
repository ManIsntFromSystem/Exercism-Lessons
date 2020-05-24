object Raindrops {

    private val mapValue = mapOf(   1 to "1",
            3 to "Pling",
       5 to "Plang",
       7 to "Plong",
       6 to "Pling",
       8 to "8",
       9 to "Pling",
      10 to "Plang",
      14 to "Plong",
      15 to "PlingPlang",
      21 to "PlingPlong",
      25 to "Plang",
      27 to "Pling",
      35 to "PlangPlong",
     49 to  "Plong",
     52 to "52",
    105 to "PlingPlangPlong",
    3125 to "Plang")

    fun convert(n: Int): String {
        return mapValue.getValue(n)
    }
}
