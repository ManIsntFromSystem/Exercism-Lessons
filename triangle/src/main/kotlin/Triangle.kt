class Triangle<out T : Number>(a: T, b: T, c: T) {
    init {
        val sides = listOf(a, b, c).map { it.toDouble() }.sorted()
        require(sides[0] > 0 && sides[0] + sides[1] > sides[2]) {"Incorrect values"}
    }

    private val numSides = setOf(a, b, c).size

    val isEquilateral: Boolean = numSides == 1
    val isIsosceles: Boolean = numSides <= 2
    val isScalene: Boolean = numSides == 3
}