package Project5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a HolidayBonus object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class HolidayBonusStudentTest {

	private double[][] dataSet = { { 2,3,4 }, { 5, 7 }, { 6, 9, 1 } };

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dataSet = null;
	}

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet);
			assertEquals(7000, result[0], .001);
			assertEquals(4000.0, result[1], .001);
			assertEquals(11000, result[2], .001);
			
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(22000, HolidayBonus.calculateTotalHolidayBonus(dataSet), .001);
	}

}
