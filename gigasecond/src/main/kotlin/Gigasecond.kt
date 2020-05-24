import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.pow

class Gigasecond(localDate: Any) {

    private val gigasecond = 10.0.pow(9.0).toLong()

    val date: LocalDateTime = if (localDate is LocalDateTime)
        localDate.plusSeconds(gigasecond)
    else (localDate as LocalDate).atTime(0,0,0)
            .plusSeconds(gigasecond) as LocalDateTime
}
