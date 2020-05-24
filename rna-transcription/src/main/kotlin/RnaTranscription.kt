fun transcribeToRna(dna: String): String =
    dna.replace(Regex("[GCTA]")) {
        when(it.value) {
            "G" -> "C"
            "C" -> "G"
            "T" -> "A"
            "A" -> "U"
            else -> it.value
        }
    }