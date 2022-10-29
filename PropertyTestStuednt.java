
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class represents GFA test cases for a Property object.
 *
 * @author Farnaz Eivazi
 * @version 7/11/2022
 */

class PropertyTestStuednt {
	Property myProperty;

	@BeforeEach
	void setUp() throws Exception {
		myProperty = new Property("AE Real_State", "Gaithersburg", 1000.00, "Bank Of America",1,2,3,4);
	}

	@AfterEach
	void tearDown() throws Exception {
		myProperty = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("AE Real_State", myProperty.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(1000.00, myProperty.getRentAmount());
	}
	
	@Test
	void testgetcity() {
		assertEquals("Gaithersburg", myProperty.getCity());
	}

	@Test
	void testGetPlot() {
		assertEquals(1, myProperty.getPlot().getX());
		assertEquals(2, myProperty.getPlot().getY());
		assertEquals(3, myProperty.getPlot().getWidth());
		assertEquals(4, myProperty.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("AE Real_State,Gaithersburg,Bank Of America,1000.0",myProperty.toString());	
	}

}
