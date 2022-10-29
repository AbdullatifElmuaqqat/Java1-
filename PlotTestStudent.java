
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a Plot object.
 * 
 * @author Farnaz Eivazi
 * @version 7/11/2022
 * 
 */
public class PlotTestStudent {
	private Plot plot1, plot2, plot3;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(1, 1, 1, 1);
		plot2 = new Plot(2, 1, 1, 1);
		plot3 = new Plot(1,2,3,4);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot2 = plot3 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot2.overlaps(plot1)); 
		assertFalse(plot1.overlaps(plot3)); 
	}
	
	@Test
	public void testToString() {
		assertEquals("1,1,1,1",plot1.toString());	
		assertEquals("2,1,1,1",plot2.toString());	
		assertEquals("1,2,3,4",plot3.toString());	
	}

}
