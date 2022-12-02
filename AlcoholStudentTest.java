import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholStudentTest {

	Alcohol alc;
	Alcohol alc1;
	Alcohol alc2;

	@BeforeEach
	public void setUp() throws Exception {
		alc = new Alcohol("Votca", Size.LARGE, true);
		alc1 = new Alcohol("Taqilla", Size.SMALL, false);
		alc2 = new Alcohol("Taqilla", Size.SMALL, false); 
	}

	@AfterEach
	public void tearDown() throws Exception {
		alc = alc1 = null;
	}

	@Test
	public void testgetOfferedInWeekends() {
		assertTrue(alc.IsOfferedInWeekends());
		assertFalse(alc1.IsOfferedInWeekends());
	}
	
	@Test
	public void testequals() {
		assertFalse(alc.equals(alc1));
		assertTrue(alc1.equals(alc2));
	}
	@Test
	public void testcalcPrice() {
		assertEquals(4.60,alc.calcPrice());
		assertEquals(2.0,alc1.calcPrice());
	}
	

	@Test
	public void testtostring() {
		assertEquals("Beverage name: Votca\nBeverage size: LARGE\nOffered in the weekend\nPrice: $4.6",alc.toString());
		assertEquals("Beverage name: Taqilla\nBeverage size: SMALL\nNot offered in the weekend\nPrice: $2.0",alc1.toString());
	}

}
