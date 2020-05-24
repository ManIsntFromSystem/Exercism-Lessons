object Prime {

    fun nth(n: Int): Int {
        require(n > 0) {"There is no zeroth prime."}
        return primes().take(n).last()
    }

        private fun primes(): Sequence<Int> = sequence {
            generateSequence(2) { it + 1}
                    .filter { it > 1 && ((2 until it)
                            .none { i -> it % i == 0 }) }
                    .forEach { yield(it) }
        }
}
