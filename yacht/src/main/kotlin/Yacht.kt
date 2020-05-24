object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int) = when (category) {
        YachtCategory.YACHT -> yachtResult(dices.toList())
        YachtCategory.ONES -> dices.filter { it == 1 }.sum()
        YachtCategory.TWOS -> dices.filter { it == 2 }.sum()
        YachtCategory.THREES -> dices.filter { it == 3 }.sum()
        YachtCategory.FOURS -> dices.filter { it == 4 }.sum()
        YachtCategory.FIVES -> dices.filter { it == 5 }.sum()
        YachtCategory.SIXES -> dices.filter { it == 6 }.sum()
        YachtCategory.CHOICE -> dices.sum()
        YachtCategory.FULL_HOUSE -> fullHouseResult(dices.toList())
        YachtCategory.FOUR_OF_A_KIND -> fourOfAKind(dices.toList())
        YachtCategory.LITTLE_STRAIGHT -> littleStraight(dices.toList())
        YachtCategory.BIG_STRAIGHT -> bigStraight(dices.toList())
    }

    private fun littleStraight(arg: List<Int>) = if (arg.containsAll((1..5).toList())) 30 else 0

    private fun bigStraight(arg: List<Int>) = if (arg.containsAll((2..6).toList())) 30 else 0

    private fun yachtResult(arg: List<Int>): Int {
        val contains = arg.filter { it == arg[0] }
        return if (contains.size == arg.size) 50 else 0
    }

    private fun fullHouseResult(arg: List<Int>) = if (arg.toSet().size == 2)
        if (arg.filter { it == arg.toSet().elementAt(0) }.size == 2 ||
                arg.filter { it == arg.toSet().elementAt(0) }.size == 3 &&
                arg.filter { it == arg.toSet().elementAt(1) }.size == 2 ||
                arg.filter { it == arg.toSet().elementAt(1) }.size == 3)
            arg.sum() else 0
    else 0

    private fun fourOfAKind(arg: List<Int>) = if (arg.toSet().size <= 2) {
        val (first, second) = arg.partition { it == arg[0] }
        when {
            first.size >= 4 -> first.take(4).sum()
            second.size >= 4 -> second.take(4).sum()
            else -> 0
        }
    } else 0

}
