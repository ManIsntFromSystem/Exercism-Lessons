fun reverse1(input: String): String =
        if (input.length >= 0) input.reversed() else ""

fun reverse(input: String): String {
    return if (input.isEmpty()) "" else input.reversed()
}