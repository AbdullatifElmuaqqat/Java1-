import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieStudentTest {
	
	Smoothie smooth;
	Smoothie smooth1;
	Smoothie smooth2;

	@BeforeEach
	public void setUp() throws Exception {
		smooth = new Smoothie("Afternoon Boost", Size.MEDIUM, 2, false);
		smooth1 = new Smoothie("Afternoon Boost", Size.MEDIUM, 0, true);
		smooth2= new Smoothie ("Afternoon Boost", Size.MEDIUM, 0, true);
	}

	@AfterEach
	public void tearDown() throws Exception {
		smooth = smooth1 = null;
	}

	@Test
	public void testgetNumOfFruits() {
		assertEquals(2, smooth.getNumOfFruits());
		assertNotEquals(1, smooth1.getNumOfFruits());
	}

	@Test
	public void testgetAddProtein() {
		assertTrue(smooth1.IsAddProtien());
		assertFalse(smooth.IsAddProtien());
	}
	
	@Test 
	public void testequals() {
		assertTrue(smooth1.equals(smooth2));
		assertFalse(smooth.equals(smooth1));
	}
	
	@Test 
	public void testcalcPrice() {
		assertEquals(4, smooth.calcPrice());
		assertEquals(4.5, smooth1.calcPrice());
	}
	
	@Test
	public void testtostring() {
		assertEquals("Beverage name: Afternoon Boost\n"
				+ "Beverage size: MEDIUM\n"
				+ "Protein isn't added\n"
				+ "Number of friuts added: 2\n"
				+ "price: $4.0",smooth.toString());
	}
}
