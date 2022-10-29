
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyStudentTest {
	Property property1,property2,property3;
	ManagementCompany mangementCo; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("AE States", "123456",10);
		property1 = new Property ("AE house", "Gaithersburg", 1000, "Abdul",1,1,1,1);	
		property2 = new Property ("AE house2", "Rockville", 2000, "MAjed",2,2,2,2);
		property3 = new Property ("AE house3", "Silver Spring", 500, "Hannah",6,2,2,2);
		
		mangementCo.addProperty(property1);
		mangementCo.addProperty(property2);
		mangementCo.addProperty(property3);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
		property1 = property2 = property3 = null;
	}

	@Test
	public void testAddProperty() {
		
		assertEquals(-4, mangementCo.addProperty(property2));	
		assertEquals(-4, mangementCo.addProperty(property1));	
		assertEquals(mangementCo.addProperty(property3), -4);
	}

	
	@Test
	public void testGetPropertiesCount() {
		assertEquals(mangementCo.getPropertiesCount(), 3);
	}
	
	@Test
	public void testGetHighestRentPropperty(){
		assertEquals(property2, mangementCo.getHighestRentPropperty());
	}
	
	@Test
	public void testIsManagmentFreeValid(){
		assertTrue(mangementCo.isMangementFeeValid());
	}
	
	@Test
	public void testIsPropertiesFull(){
		assertFalse(mangementCo.isPropertiesFull());
	}
	
	
	@Test
	public void tstGetTotalRent(){
		assertEquals(3500,mangementCo.getTotalRent(),0);
	} 
	
	@Test
	public void testRemoveLastProperty(){
		mangementCo.removeLastProperty();
		assertEquals(mangementCo.getProperties()[3], null);
	} 
	
	//NEED WORK
	@Test
	public void testgetPlot(){
		assertEquals(mangementCo.getPlot(),property1.getPlot());
	} 
	
	@Test
	public void testgetName(){
		assertEquals(mangementCo.getName(), "AE States");
		assertEquals(property1.getPropertyName(), "AE house");
		assertEquals(property2.getPropertyName(),"AE house2");
	} 
	
	//NEED WORK
	@Test
	public void testgetProperties(){
		assertEquals(mangementCo.getName(), "AE States");
		assertEquals(property1.getPropertyName(), "AE house");
		assertEquals(property2.getPropertyName(),"AE house2");
	} 
	
	@Test 
	public void testgetTaxID() {
		assertEquals(mangementCo.getTaxID(),"123456");
	}
	
	@Test
	public void testgetMgmFee() {
		assertEquals(mangementCo.getMgmFee(), 0,10);
	}
	
	@Test
	public void testToString() {
		assertEquals("List of the properties for AE States, taxID: 123456\n"
				+ "______________________________________________________\n"
				+ "AE house,Gaithersburg,Abdul,1000.0\n"
				+ "AE house2,Rockville,MAjed,2000.0\n"
				+ "AE house3,Silver Spring,Hannah,500.0\n"
				+ "null\n"
				+ "null\n"
				+"______________________________________________________\n"
				+ "\n"
				+"total management Fee: 350.0"
				, mangementCo.toString());
	}
	
}
