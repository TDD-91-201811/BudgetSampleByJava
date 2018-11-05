import java.util.List;

public class StubBudgetRepository implements IRepository<Budget>{
	private List<Budget> _budgets;

	public void SetBudgets(List<Budget> budgets) {
		_budgets = budgets;
	}
}
