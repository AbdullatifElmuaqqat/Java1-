import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DayStudentTest {

	Day day = Day.MONDAY;
	Day day1 = Day.SATURDAY;

	@Test
	public void testDay() {
		assertEquals(day, Day.MONDAY);
		assertNotEquals(day1, Day.TUESDAY);
	}

}

