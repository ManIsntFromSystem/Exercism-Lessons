import java.lang.Math.floorDiv
import java.util.*
import kotlin.random.Random.Default.nextInt


class DndCharacter {

    val strength: Int by lazy { ability() }
    val dexterity: Int by lazy { ability() }
    val constitution: Int by lazy { ability() }
    val intelligence: Int by lazy { ability() }
    val wisdom: Int by lazy { ability() }
    val charisma: Int by lazy { ability() }
    val hitpoints: Int by lazy { 10 + modifier(constitution) }

    companion object {

        fun ability() = nextInt(3, 19)

        fun modifier(score: Int): Int = floorDiv((score - 10), 2)
    }
}

