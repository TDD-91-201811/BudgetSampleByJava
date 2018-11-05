import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class Accouting {
	private IRepository<Budget> budgetRepository;

	public Accouting(IRepository<Budget> budgetRepository) {

		this.budgetRepository = budgetRepository;
	}

	public Double TotalAmount(LocalDate start, LocalDate end) {
		List<Budget> budgets = budgetRepository.getAll();
		if (budgets.isEmpty()) {

			return 0d;
		}

		long days = DAYS.between(start, end) + 1;
		return (double) days;
	}
}
