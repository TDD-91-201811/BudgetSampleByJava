import java.time.LocalDate;
import java.time.YearMonth;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Budget {
	private String yearMonth;
	private int amount;

	public Budget(String yearMonth, int amount) {
		this.yearMonth = yearMonth;
		this.amount = amount;
	}

	public LocalDate firstDay() {
		YearMonth yearMonth = YearMonth.parse(this.yearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
		return yearMonth.atDay(1);
	}
}
