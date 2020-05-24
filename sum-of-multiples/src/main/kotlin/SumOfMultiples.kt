object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        if (factors.isEmpty() && limit <= 0) return 0

        val listValues = mutableListOf<Int>()

        for (fact in factors.filter { it > 0 })
            for (i in limit-1 downTo factors.min()!!)
                if (i % fact == 0)
                    listValues += i
        return listValues.toSet().sum()
    }
}
