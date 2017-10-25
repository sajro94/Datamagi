package opg2;

import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.*;

public class MainApp {

	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.of(2017, 11, 1);
		Rental r1 = new Rental(12, 14, 100.0, ld1);
		LocalDate ld2 = LocalDate.now().plusMonths(10);
		Rental r2 = new Rental(12, 14, 100, ld2);

		System.out.println(r1.getTotalPrice());
		System.out.println(r2.getTotalPrice());

		System.out.println(r1.getStartDate());
		System.out.println(r2.getStartDate());

		System.out.println(r1.getEndDate());
		System.out.println(r2.getEndDate());

		Period ldDiff = ld1.until(ld2);
		System.out.println(
				String.format("År: %s%nMåneder:%s%nDage:%s", ldDiff.getYears(), ldDiff.getMonths(), ldDiff.getDays()));
		System.out.println(WEEKS.between(ld1, ld2));
	}

}
