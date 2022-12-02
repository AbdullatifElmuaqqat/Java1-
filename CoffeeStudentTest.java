import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeStudentTest {


	Coffee cof;
	Coffee cof1;
	Coffee cof2;

	@BeforeEach
	public void setUp() throws Exception {
		cof = new Coffee("Latte", Size.LARGE, true, true);
		cof1 = new Coffee("Mocha", Size.SMALL, false, false);
		cof2 = new Coffee("Mocha", Size.SMALL, false, false);
	}

	@AfterEach
	public void tearDown() throws Exception {
		cof = cof1 = cof2= null;
	}

	@Test
	public void testIsExtra_Shot() {
		assertTrue(cof.IsExtra_Shot());
		assertFalse(cof1.IsExtra_Shot());
	}
	
	@Test
	public void testIsSyrup() {
		assertTrue(cof.IsSyrup());
		assertFalse(cof1.IsSyrup());
	}
	
	@Test
	public void testequals() {
		assertFalse(cof.equals(cof1));
		assertTrue(cof1.equals(cof2));
	}
	@Test
	public void testcalcPrice() {
		assertEquals(5.0,cof.calcPrice());
		assertEquals(2.0,cof1.calcPrice());
	}
	

	@Test
	public void testtostring() {
		assertEquals("Beverage name: Latte\nBeverage size: LARGE\nExtra Shot\nExtra Syrup\nPrice: $5.0",cof.toString());
		assertEquals("Beverage name: Mocha\nBeverage size: SMALL\nNo Extra Shot\nNo Extra Syrup\nPrice: $2.0",cof1.toString());
	}

}
