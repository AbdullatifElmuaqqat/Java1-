import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopStudentTest {

	BevShop bev;
	
	@Before
	public void setUp() throws Exception {
		bev = new BevShop();
	}

	@After
	public void tearDown() throws Exception {
		bev = null;
	}

	@Test
	public void testisValidTime()
	{
		
		assertTrue(bev.isValidTime(9));
		assertTrue(bev.isValidTime(10));
		assertFalse(bev.isValidTime(24));
		assertFalse(bev.isValidTime(2));
	}
	
	@Test
	public void testIsMaxFruit() {
		assertFalse(bev.isMaxFruit(3));
	}

	@Test
	public void testIsEligibleForMore() {
		
		bev.startNewOrder(15, Day.SUNDAY, "Ryan", 25);
		bev.processAlcoholOrder("wine", Size.LARGE);
		assertTrue(bev.isEligibleForMore());
		bev.processAlcoholOrder("wine2", Size.SMALL);
		assertTrue(bev.isEligibleForMore());
		bev.processAlcoholOrder("wine3", Size.MEDIUM);
		assertTrue(bev.isEligibleForMore());
	}
	
	@Test
	public void testGetMaxNumOfFruits() {
		assertEquals(5,bev.getMaxNumOfFruits());
	}

	@Test
	public void testGetMinAgeForAlcohol() {
		assertEquals(21,bev.getMinAgeForAlcohol());
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		assertEquals(3,bev.getMaxOrderForAlcohol());
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		
		bev.startNewOrder(17, Day.SATURDAY, "Karen", 22);
		bev.processAlcoholOrder("Corona", Size.MEDIUM);
		assertEquals(1,bev.getNumOfAlcoholDrink());
		bev.processAlcoholOrder("Corona1", Size.LARGE);
		assertEquals(2,bev.getNumOfAlcoholDrink());
		
	}

	@Test
	public void testGetCurrentOrder() {
		bev.startNewOrder(20, Day.SATURDAY, "Abdull", 30);
		bev.processSmoothieOrder("Gatorade", Size.MEDIUM, 3, false);
		bev.processSmoothieOrder("Super sunny", Size.SMALL, 2, false);

		assertEquals(bev.getOrderAtIndex(0), bev.getCurrentOrder());
	}

	@Test
	public void testGetOrderAtIndex() {
		bev.startNewOrder(20, Day.THURSDAY, "Sohaib", 10);
		bev.processCoffeeOrder("Capuccino", Size.SMALL, false, false);
		assertEquals(bev.getCurrentOrder(),bev.getOrderAtIndex(0));
				
	}
	
	@Test
	public void testisValidAge()
	{
		assertFalse(bev.isValidAge(20));
		assertTrue(bev.isValidAge(23));
	}
	
	@Test
	public void testStartNewOrder()
	{
		bev.startNewOrder(9,Day.SUNDAY,"Abdul", 40);
		assertEquals(40, bev.getCurrentOrder().getOrderTime());
		assertEquals(Day.SUNDAY, bev.getCurrentOrder().getOrderDay());
		assertEquals(40, bev.getCurrentOrder().getOrderTime());
		assertEquals("Abdul", bev.getCurrentOrder().getCustomer().getName());
		assertEquals(40, bev.getCurrentOrder().getCustomer().getAge());
		assertEquals(0,bev.getNumOfAlcoholDrink());
		assertTrue(bev.getCurrentOrder().getTotalItems() == 0);
	
	}
	
	@Test
	public void testProcessAlcoholOrder()
	{
		bev.startNewOrder(8,Day.MONDAY,"Abdul", 30);
		
		bev.processAlcoholOrder("Taqilla", Size.LARGE);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevname().equals("Taqilla"));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevsize().equals(Size.LARGE));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevtype().equals(Type.ALCOHOL));	
		assertTrue(bev.isEligibleForMore());
		bev.processAlcoholOrder("tonic", Size.MEDIUM);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevname().equals("tonic"));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevsize().equals(Size.MEDIUM));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevtype().equals(Type.ALCOHOL));	
		assertTrue(bev.isEligibleForMore());
		bev.processAlcoholOrder("Wine", Size.SMALL);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bev.getCurrentOrder().getBeverage(2).getBevname().equals("Wine"));
		assertTrue(bev.getCurrentOrder().getBeverage(2).getBevsize().equals(Size.SMALL));
		assertTrue(bev.getCurrentOrder().getBeverage(2).getBevtype().equals(Type.ALCOHOL));	
		assertEquals(1,bev.totalNumOfMonthlyOrders());

	}
	
	@Test
	public void testProcessSmoothieOrder()
	{
		bev.startNewOrder(9,Day.SUNDAY,"Abdul", 40);
		assertTrue (bev.isMaxFruit(6));
		assertFalse (bev.isMaxFruit(5));
		bev.processSmoothieOrder("Morning Boost", Size.LARGE, 3, false);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 1);
		
		Smoothie smooth = (Smoothie) bev.getCurrentOrder().getBeverage(0);
		
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevname().equals("Morning Boost"));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevsize().equals(Size.LARGE));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevtype().equals(Type.SMOOTHIE));
		
		
		assertTrue(smooth.getNumOfFruits() == 3);
		assertFalse(smooth.IsAddProtien());
		 
		
		bev.processSmoothieOrder("Afternoon Boost", Size.SMALL, 1, true);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 2);
		
		smooth =  (Smoothie) bev.getCurrentOrder().getBeverage(1);
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevname().equals("Afternoon Boost"));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevsize().equals(Size.SMALL));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevtype().equals(Type.SMOOTHIE));
		
		assertTrue(smooth.getNumOfFruits() == 1);
		assertTrue(smooth.IsAddProtien());
		assertEquals(1,bev.totalNumOfMonthlyOrders());
		
	}
	
	@Test
	public void testProcessCoffeeOrder()
	{
		Coffee cof;
		bev.startNewOrder(8,Day.MONDAY,"Ryan", 40);
		bev.processCoffeeOrder("Mocha", Size.MEDIUM, true, false);
		assertTrue(bev.getCurrentOrder().getTotalItems() == 1);
		
		cof = (Coffee) bev.getCurrentOrder().getBeverage(0);
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevname().equals("Mocha"));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevsize().equals(Size.MEDIUM));
		assertTrue(bev.getCurrentOrder().getBeverage(0).getBevtype().equals(Type.COFFEE));
		assertTrue(cof.IsExtra_Shot());
		assertFalse(cof.IsSyrup());
		
		bev.processCoffeeOrder("Black Coffee", Size.LARGE, false, false);
		cof = (Coffee) bev.getCurrentOrder().getBeverage(1);
		
		assertTrue(bev.getCurrentOrder().getTotalItems() == 2);
		
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevname().equals("Black Coffee"));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevsize().equals(Size.LARGE));
		assertTrue(bev.getCurrentOrder().getBeverage(1).getBevtype().equals(Type.COFFEE));
		assertFalse(cof.IsExtra_Shot()); 
		assertFalse(cof.IsSyrup()); 
		
	}
	
	@Test
	public void testFindOrder()
	{
	 
		int orderNum;
		bev.startNewOrder(8,Day.FRIDAY,"Tariq", 19);
		bev.processCoffeeOrder("Latte", Size.SMALL, true, false);
		bev.processCoffeeOrder("Mocha", Size.MEDIUM, false, false);
		bev.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);
		
		orderNum = bev.getCurrentOrder().getOrderNum();
		
		bev.startNewOrder(8,Day.SUNDAY,"Abdul", 20);
		bev.processSmoothieOrder("Afternoon Boost", Size.SMALL, 2, true);
		
		assertEquals(0,bev.findOrder(orderNum));
		
		orderNum = bev.getCurrentOrder().getOrderNum();
		assertEquals(1,bev.findOrder(orderNum));
		
	}
	@Test
	public void testTotalOrderPrice()
	{
	 	int orderNum;
	
		bev.startNewOrder(8,Day.TUESDAY,"Ryan", 17);
		bev.processCoffeeOrder("Latte", Size.MEDIUM, false, false); 
		bev.processCoffeeOrder("Mocha", Size.SMALL, false, true);
		bev.processCoffeeOrder("Cappuccino", Size.LARGE,true, false);
	 	orderNum = bev.getCurrentOrder().getOrderNum();

	 
		assertEquals(10,bev.totalOrderPrice(orderNum),.01);
		
	}
	@Test
	public void testTotalMonthlySale()
	{
		bev.startNewOrder(8,Day.MONDAY,"Abdul", 20);
		bev.processCoffeeOrder("Mocha", Size.LARGE, true, false); 
		bev.processCoffeeOrder("Cappuccino", Size.MEDIUM, false, false);
		bev.processCoffeeOrder("Latte", Size.SMALL,true, true);
	
		bev.startNewOrder(8,Day.SUNDAY,"Ryan", 17);
		bev.processSmoothieOrder("Morning Boost", Size.LARGE, 3, false);
		bev.processAlcoholOrder("Wine", Size.MEDIUM);
		
		bev.startNewOrder(18,Day.SATURDAY,"Danna", 19);
		bev.processSmoothieOrder("Gatorade", Size.LARGE, 2, false);
		bev.processCoffeeOrder("Latte", Size.MEDIUM,false, true);		 

	 
		assertEquals(26, bev.totalMonthlySale(), .01 );
 
	}
	
	@Test
	public void testSortOrders()
	{
		bev.startNewOrder(10, Day.FRIDAY, "Abdul", 18);
		bev.startNewOrder(20, Day.MONDAY, "Haddad", 19);
		bev.startNewOrder(19, Day.SATURDAY, "Hannah", 12);
		bev.startNewOrder(16, Day.FRIDAY, "Ryan", 20);

		bev.sortOrders();
		assertTrue(bev.getOrderAtIndex(0).getOrderNum() < bev.getOrderAtIndex(1).getOrderNum());
		assertTrue(bev.getOrderAtIndex(1).getOrderNum() < bev.getOrderAtIndex(2).getOrderNum());
		assertFalse(bev.getOrderAtIndex(2).getOrderNum() > bev.getOrderAtIndex(3).getOrderNum());
	}
	
	@Test
	public void testToString() {
		
		bev.startNewOrder(8,Day.MONDAY,"Ryan", 16);
		bev.processCoffeeOrder("Latte", Size.SMALL, true, false); 
		 
	
		bev.startNewOrder(8,Day.SUNDAY,"Tariq", 21);
		bev.processSmoothieOrder("Detox", Size.SMALL, 1, false);
			  
		 
		assertTrue(bev.toString().contains( String.valueOf(bev.getOrderAtIndex(0).getOrderNum())));
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(0).getCustomer().getName()) );
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(0).getBeverage(0).getBevsize().toString())) ;
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(0).getBeverage(0).getBevname()));
		
	 	
		assertTrue(bev.toString().contains( String.valueOf(bev.getOrderAtIndex(1).getOrderNum()) ));
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(1).getCustomer().getName()) );
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(1).getBeverage(0).getBevsize().toString()) )  ;
		assertTrue(bev.toString().contains(bev.getOrderAtIndex(1).getBeverage(0).getBevname()) );
		
		assertTrue(bev.toString().contains( String.valueOf(bev.totalMonthlySale())));
		
 
		 
	}
}	

 
