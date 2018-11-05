import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountingTests {

	private final StubBudgetRepository budgetRepository = new StubBudgetRepository();
	private final Accouting accouting = new Accouting(budgetRepository);

	@Test
	public void no_budgets() {

		totalAmountShouldBe(0, LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
	}

	private void totalAmountShouldBe(int expected, LocalDate start, LocalDate end) {
		Double totalAmount = accouting.TotalAmount(start, end);
		assertEquals(expected, totalAmount, 0.01);
	}
}
