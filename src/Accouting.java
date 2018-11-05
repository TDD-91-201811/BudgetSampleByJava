import joey.Period;

import java.time.LocalDate;
import java.util.List;

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

		Period period = new Period(start, end);
		Budget budget = budgets.get(0);
		if (period.getEnd().isBefore(budget.firstDay())) {
			return 0d;
		}

		long days = period.getDays();
		return (double) days;
	}
}
