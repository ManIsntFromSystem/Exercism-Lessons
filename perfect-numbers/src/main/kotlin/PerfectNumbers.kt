import java.lang.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0 ) throw RuntimeException("Incorrect value")

    val listDivisors = mutableListOf<Int>()
    for (i in (naturalNumber/2) downTo 1)
        if (naturalNumber % i == 0) listDivisors += i
    return when {
        listDivisors.sum() == naturalNumber -> Classification.PERFECT
        listDivisors.sum() > naturalNumber -> Classification.ABUNDANT
        listDivisors.sum() < naturalNumber -> Classification.DEFICIENT
        else -> throw RuntimeException("Incorrect value")
    }
}
