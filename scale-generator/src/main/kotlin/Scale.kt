class Scale(private val tonic: String) {

    fun chromatic(): List<String> {
        TODO("Implement this function to complete the task")
    }

    fun interval(intervals: String): List<String> {
        TODO("Implement this function to complete the task")
    }

    fun notesEqual(left: String, right: String) = left.equals(right) || when(left) {
        // A# == Bb
        "A#" -> right.equals("Bb")
        "Bb" -> right.equals("A#")
        // C# == Db
        "C#" -> right.equals("Db")
        "Db" -> right.equals("C#")
        // D# == Eb
        "D#" -> right.equals("Eb")
        "Eb" -> right.equals("D#")
        // F# == Gb
        "F#" -> right.equals("Gb")
        "Gb" -> right.equals("F#")
        // G# == Ab
        "G#" -> right.equals("Ab")
        "Ab" -> right.equals("G#")
        else -> false
    }

}
