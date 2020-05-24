class KindergartenGarden(private val diagram: String) {

    fun getPlantsOfStudent(student: String): List<String> {
        val (first, second) = diagram.split("\n")
        val index = Students.valueOf(student.toUpperCase()).index
        return listOf(Plants.valueOf(first[index].toString()).upperValue,
                Plants.valueOf(first[index + 1].toString()).upperValue,
                Plants.valueOf(second[index].toString()).upperValue,
                Plants.valueOf(second[index + 1].toString()).upperValue)
    }
}

enum class Students(val index: Int){
    ALICE(0),
    BOB(2),
    CHARLIE(4),
    DAVID(6),
    EVE(8),
    FRED(10),
    GINNY(12),
    HARRIET(14),
    ILEANA(16),
    JOSEPH(18),
    KINCAID(20),
    LARRY(22)
}
enum class Plants(val upperValue: String){
    V("violets"),
    C("clover"),
    R("radishes"),
    G("grass")
}
