import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountingTests {

	private final StubBudgetRepository budgetRepository = new StubBudgetRepository();
	private final Accouting accouting = new Accouting(budgetRepository);

	@Test
	public void no_budgets() {

		givenBudgets();
		totalAmountShouldBe(0, LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
	}

	@Test
	public void period_inside_budget_month() {

		givenBudgets(new Budget("201004", 30));
		totalAmountShouldBe(1, LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
	}

	@Test
	public void period_no_overlapping_before_budget_firstDay() {

		givenBudgets(new Budget("201004", 30));
		totalAmountShouldBe(0, LocalDate.of(2010, 3, 31), LocalDate.of(2010, 3, 31));
	}

	@Test
	public void period_no_overlapping_after_budget_lastDay() {

		givenBudgets(new Budget("201004", 30));
		totalAmountShouldBe(0, LocalDate.of(2010, 5, 1), LocalDate.of(2010, 5, 1));
	}

	@Test
	public void period_overlapping_budget_firstDay() {

		givenBudgets(new Budget("201004", 30));
		totalAmountShouldBe(1
				, LocalDate.of(2010, 3, 31)
				, LocalDate.of(2010, 4, 1));
	}

	@Test
	public void period_overlapping_budget_lastDay() {

		givenBudgets(new Budget("201004", 30));
		totalAmountShouldBe(1
				, LocalDate.of(2010, 4, 30)
				, LocalDate.of(2010, 5, 1));
	}

	@Test
	public void budget_daily_amount_is_10() {

		givenBudgets(new Budget("201004", 300));
		totalAmountShouldBe(20
				, LocalDate.of(2010, 4, 1)
				, LocalDate.of(2010, 4, 2));
	}

	@Test
	public void invalid_period() {

		givenBudgets(new Budget("201004", 300));
		totalAmountShouldBe(0
				, LocalDate.of(2010, 4, 3)
				, LocalDate.of(2010, 4, 2));
	}

	@Test
	public void multiple_budgets() {

		givenBudgets(
				new Budget("201004", 300),
				new Budget("201005", 31));

		totalAmountShouldBe(12
				, LocalDate.of(2010, 4, 30)
				, LocalDate.of(2010, 5, 2));
	}

	private void givenBudgets(Budget... budgets) {
		budgetRepository.SetBudgets(asList(budgets));
	}

	private void totalAmountShouldBe(int expected, LocalDate start, LocalDate end) {
		Double totalAmount = accouting.TotalAmount(start, end);
		assertEquals(expected, totalAmount, 0.01);
	}
}
