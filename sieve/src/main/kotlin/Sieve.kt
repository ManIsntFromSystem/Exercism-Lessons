
object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> =
            IntArray(upperBound + 1) {
                if (it > 1) it else 0
            }.apply {
                (2..upperBound)
                        .takeWhile { it * it <= upperBound }
                        .filter { this[it] != 0 }
                        .forEach {
                            (it * 2..upperBound step it)
                                    .forEach { x -> this[x] = 0 }
                        }
            }.filter { it != 0 }
}