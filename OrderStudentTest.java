import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Any method that has order number in it can't make a junit test to it since order number is randomly generated.

class OrderStudentTest {
	Order ord,ord1;

	@BeforeEach
	void setUp() throws Exception {
		ord = new Order(18, Day.SATURDAY, new Customer("Abdull", 20));
		ord1 = new Order(21, Day.MONDAY,new Customer("Ryan", 17));
	}

	@AfterEach
	void tearDown() throws Exception {
		ord = ord1 = null;
	}
	
	@Test
	void testGetTotalItems() {
		ord.addNewBeverage("Fruit Punch", Size.SMALL, 3, false);
		ord.addNewBeverage("Latte", Size.SMALL, true, true); 
		ord.addNewBeverage("wine", Size.MEDIUM); 
		assertEquals(3,ord.getTotalItems());
	}
	
	@Test
	void testAddNewBeverage() {
		assertTrue(ord.getTotalItems()== 0);
		ord.addNewBeverage("wine", Size.SMALL);
		assertTrue(ord.getBeverage(0).getBevtype().equals(Type.ALCOHOL));
	}

	@Test
	void testAddNewBeverage1() {
		assertTrue(ord1.getTotalItems() == 0);
		ord1.addNewBeverage("Fruit Punch", Size.SMALL, 1, false);
		assertTrue(ord1.getBeverage(0).getBevtype().equals(Type.SMOOTHIE));
	}

	@Test
	void testAddNewBeverage2() {
		
		assertTrue(ord.getTotalItems() == 0);
		ord.addNewBeverage("Mocha", Size.LARGE, true, false);
		assertTrue(ord.getBeverage(0).getBevtype().equals(Type.COFFEE));
	}
	

	@Test
	void testCalcOrderTotal() {
		ord.addNewBeverage("Mocha", Size.LARGE, false, false); 
		ord.addNewBeverage("Corona", Size.MEDIUM); 
		ord.addNewBeverage("Fruits", Size.SMALL, 1, false);
		assertEquals(9,ord.calcOrderTotal());
	}

	@Test
	void testFindNumOfBeveType() {
		ord1.addNewBeverage("American coffee", Size.MEDIUM, false, true);
		ord1.addNewBeverage("Wow s moothie", Size.LARGE, 4, true); 
		ord1.addNewBeverage("Berry", Size.MEDIUM, 3, false);
		assertEquals(1, ord1.findNumOfBeveType(Type.COFFEE));
		assertEquals(2,ord1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(0,ord1.findNumOfBeveType(Type.ALCOHOL));
		
	}


	@Test
	void testGetBeverage() {
		ord.addNewBeverage("Latte", Size.LARGE, true, true); 
		
		assertEquals("Beverage name: Latte\nBeverage size: LARGE" +
				"\nExtra Shot\nExtra Syrup\nPrice: $5.0",ord.getBeverage(0).toString());
		
	}

	@Test
	void testGetCustomer() {
		assertEquals("Name: Abdull\nAge: 20", ord.getCustomer().toString());
	}

	@Test
	void testGetDay() {
		assertEquals(Day.SATURDAY,ord.getOrderDay());
		assertEquals(Day.MONDAY,ord1.getOrderDay());
	}

	@Test
	void testGetOrderDay() {
		assertEquals(Day.SATURDAY,ord.getOrderDay());
	}

	@Test
	void testGetOrderTime() {
		assertEquals(18,ord.getOrderTime());
	}

	@Test
	void testisWeekend() {
		assertTrue(ord.isWeekend());
	}

	@Test
	void testToString() {
		ord.addNewBeverage("Mocha", Size.LARGE, false, false);
		assertEquals("order number: " + ord.getOrderNum() +"\norder time: 18\norder day: " + ord.getOrderDay() + 
				"\nName: Abdull\nAge: 20\nBeverage name: Mocha\nBeverage size: " + ord.getBeverage(0).getBevsize()
				+ "\nNo Extra Shot\nNo Extra Syrup\nPrice: $4.0\nTotal: $4.0",ord.toString());
	}
}

