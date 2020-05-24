object Flattener {
    fun flatten(source: Collection<Any?>): List<Int> {
        val result = mutableListOf<Int?>()
        source.forEach {
            when (it) {
                is Int -> result.add(it)
                (it as List<Int>).size > 0 ->
                    result.addAll((it))
                else -> result.add(it)
            }
        }
        return result
    }

        tailrec fun myConvert(list: Any?): List<Int> {
            if (list is List<*>)
        }
    }