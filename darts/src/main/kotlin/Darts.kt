object Darts {

    fun <T> score(x: T, y: T): Int {
        val myX = x.toString().toDouble()
        val myY = y.toString().toDouble()

        return when {
            formulaCalculation(myX, myY, 1) -> 10
            formulaCalculation(myX, myY, 5) -> 5
            formulaCalculation(myX, myY, 10) -> 1
            else -> 0
        }
    }

    private fun formulaCalculation(x: Double, y: Double, r: Int) = x*x + y*y <= r*r
}
