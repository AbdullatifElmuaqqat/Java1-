import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	private GradeBook b1;
	private GradeBook b2;

	@Before
	public void setUp() throws Exception {
		b1 = new GradeBook(5);
		b2 = new GradeBook(5);
		
		b1.addScore(50.0);
		b1.addScore(30.0);
		b1.addScore(20.0);
		
		b2.addScore(60.0);
		b2.addScore(55.0);
		b2.addScore(70.0);
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		b2 = null;
	}

	@Test
	public void testAddScore() {
		
//		assertTrue("50.0 30.0 20.0".equals(b1.tostring()));
//		assertTrue("60.0 55.0 70.0".equals(b2.tostring()));
		
		assertTrue(b1.tostring().equals("50.0 30.0 20.0"));
		assertTrue(b2.tostring().equals("60.0 55.0 70.0"));
		
		assertEquals(3, b1.getScoreSize(), .001);
		assertEquals(3, b2.getScoreSize(), .001);

	}
	
	@Test
	public void testsum() {
		assertEquals(100,b1.sum(),0.0001);
		assertEquals(185,b2.sum(),0.0001);
	}
	
	@Test
	public void testMinimum() {
		assertEquals(20, b1.minimum(),0.001);
		assertEquals(55, b2.minimum(),0.001);
	}
	
	@Test
	public void testFinalScore() {
		
		assertEquals(80,b1.finalScore(),0.001);
		assertEquals(130,b2.finalScore(),0.001);

	}


}
