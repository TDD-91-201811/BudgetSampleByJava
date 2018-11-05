import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountingTests {

	private final StubBudgetRepository budgetRepository = new StubBudgetRepository();
	private final Accouting accouting = new Accouting(budgetRepository);

	@Test
	public void no_budgets() {

		budgetRepository.SetBudgets(asList());
		totalAmountShouldBe(0, LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
	}

	@Test
	public void period_inside_budget_month() {

		budgetRepository.SetBudgets(asList(new Budget("201804", 30)));
		totalAmountShouldBe(1, LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
	}

	private void totalAmountShouldBe(int expected, LocalDate start, LocalDate end) {
		Double totalAmount = accouting.TotalAmount(start, end);
		assertEquals(expected, totalAmount, 0.01);
	}
}
