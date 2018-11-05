import java.time.LocalDate;
import java.time.YearMonth;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.YearMonth.parse;

public class Budget {
	private String yearMonth;
	private int amount;

	public Budget(String yearMonth, int amount) {
		this.yearMonth = yearMonth;
		this.amount = amount;
	}

	public LocalDate firstDay() {
		YearMonth yearMonth = getYearMonth();
		return yearMonth.atDay(1);
	}

	public LocalDate lastDay() {
		return getYearMonth().atEndOfMonth();
	}

	private YearMonth getYearMonth() {
		return parse(this.yearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
	}

	public Period createPeriod() {
		return new Period(firstDay(), lastDay());
	}
}
