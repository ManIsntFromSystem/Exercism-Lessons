import javax.crypto.Cipher

class CustomSet(vararg values: Int) {

    private var mySet = values.toMutableSet()

    fun isEmpty(): Boolean {
        return mySet.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        if (this.mySet.isEmpty()) return true
        else if (other.mySet.isEmpty()) return false
        return other.mySet.containsAll(this.mySet)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return intersection(other).isEmpty()
    }

    fun contains(other: Int): Boolean {
        return mySet.isNotEmpty() && mySet.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        val commonElements = mutableListOf<Int>()
        other.mySet.forEach {
            if (this.mySet.contains(it))
                commonElements += it
        }
        return CustomSet(*commonElements.toIntArray())
    }

    fun add(other: Int) {
        if (!mySet.contains(other))
            mySet.add(other)
    }

    override fun equals(other: Any?): Boolean {
        var equals = true

        if (mySet == (other as CustomSet).mySet ) return true

        mySet.forEach { if((other as CustomSet).mySet.contains(it)
                || (other as CustomSet).mySet.isEmpty())
            equals = false
        }
        (other as CustomSet).mySet.forEach {
            if(mySet.contains(it) || mySet.isEmpty())
                equals = false
        }
        return equals

    }

    operator fun plus(other: CustomSet): CustomSet {
        return CustomSet(*(mySet.plus(other.mySet)).toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(*(mySet.minus(other.mySet)).toIntArray())
    }
}
