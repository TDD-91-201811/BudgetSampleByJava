
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

	public long overlappingDays(Budget budget) {
		if (getStart().isAfter(budget.lastDay()) || getEnd().isBefore(budget.firstDay())) {

			return 0;
		}

		LocalDate overlappingStart = budget.firstDay().isAfter(start)
				? budget.firstDay()
				: start;

		LocalDate effectiveEnd = budget.lastDay().isBefore(end)
				? budget.lastDay()
				: end;

		return DAYS.between(overlappingStart, effectiveEnd) + 1;
	}
}
