
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Period {
	private final LocalDate start;
	private final LocalDate end;

	public Period(LocalDate start, LocalDate end) {
		this.start = start;
		this.end = end;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public long overlappingDays(Period another) {

		if (getStart().isAfter(another.getEnd()) || getEnd().isBefore(another.getStart())) {

			return 0;
		}

		LocalDate overlappingStart = another.getStart().isAfter(start)
				? another.getStart()
				: start;

		LocalDate effectiveEnd = another.getEnd().isBefore(end)
				? another.getEnd()
				: end;

		return DAYS.between(overlappingStart, effectiveEnd) + 1;
	}
}
