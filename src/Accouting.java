
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Accouting {
	private IRepository<Budget> budgetRepository;

	public Accouting(IRepository<Budget> budgetRepository) {

		this.budgetRepository = budgetRepository;
	}

	public Double TotalAmount(LocalDate start, LocalDate end) {

		Period period = new Period(start, end);

		return budgetRepository.getAll().stream()
				.mapToDouble(budget -> budget.getOverlappingAmount(period))
				.sum();
	}
}
