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

		long days = new Period(start, end).getDays();
		return (double) days;
	}
}
