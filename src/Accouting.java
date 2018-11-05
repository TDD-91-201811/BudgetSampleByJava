
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
		double dailyAmount = budget.getAmount() / budget.days();

		long overlappingDays = period.overlappingDays(budget.createPeriod());
		return dailyAmount * overlappingDays;
	}
}
