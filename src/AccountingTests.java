import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountingTests {
	@Test
	public void no_budgets() {

		Accouting accouting = new Accouting(new StubBudgetRepository());
		BigDecimal totalAmount = accouting.TotalAmount(LocalDate.of(2010, 4, 1), LocalDate.of(2010, 4, 1));
		assertEquals(0, totalAmount);
	}
}
