 
 

public class BevShopDriver {

	public static void main(String[] args) {

		int cusAge, cusOrderNum;

		Customer Customer;
		int InvalidTime = 8, anotherInvalidTime = 24;

		BevShop bev = new BevShop();
		
		if ( !bev.isValidTime(InvalidTime))
			System.out.println( "Failed the test for invalid time!!"); 
		 
		if ( bev.isValidTime(anotherInvalidTime))
			System.out.println( "The time is valid!");  
		
		System.out.println(bev.getMaxOrderForAlcohol());
		System.out.println(bev.getMinAgeForAlcohol()); 
		System.out.println("Start a new order"); 
		bev.startNewOrder(20, Day.SUNDAY, "Micheal", 35);

		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal());

		Customer = bev.getCurrentOrder().getCustomer();

		Customer.setName("Christian");
		Customer.setAge(13);

		System.out.println(bev.getCurrentOrder().getCustomer().getName()); 
		System.out.println(bev.getCurrentOrder().getCustomer().getAge());

		cusAge = bev.getCurrentOrder().getCustomer().getAge();
		System.out.println(bev.isValidAge(cusAge));
		if (bev.isValidAge(cusAge)) {
			System.out.println("Add alcohol drink"); 

			bev.processAlcoholOrder("Tacquila", Size.SMALL);
		}

		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal()); 
		System.out.println(bev.isEligibleForMore()); 

		System.out.println("Add second alcohol drink"); 
	
		bev.processAlcoholOrder("Mohotchi", Size.MEDIUM);
		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal()); 
		System.out.println(bev.getNumOfAlcoholDrink());

		System.out.println("Add third alcohol drink");
		bev.processAlcoholOrder("Covid", Size.SMALL);

		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal()); 

		System.out.println(bev.getNumOfAlcoholDrink()); 

		if (!bev.isEligibleForMore()) {
			System.out.println("Maximum alcohol drink for this order"); 
		}
		
		System.out.println("Add a COFFEE to order"); 
		bev.processCoffeeOrder("Latte", Size.SMALL, true, true);
		System.out.println(bev.getNumOfAlcoholDrink()); 

		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal()); 
		cusOrderNum = bev.getCurrentOrder().getOrderNum();

		if (bev.findOrder(cusOrderNum) != -1) {
			System.out.println("Total on the Order:" + bev.totalOrderPrice(cusOrderNum)); 
		}

		else {

			System.out.println("order not found! Should not get to here!");
	}
		
		System.out.println("Start a new order");

		bev.startNewOrder(9, Day.FRIDAY, "kelyian", 21);

		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal()); 
		System.out.println("Add a SMOOTHIE to order");
								
		bev.processSmoothieOrder("Boost Smoothie", Size.LARGE, 4, true);
		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal());
		
		System.out.println("Add a COFFEE to order");
		bev.processCoffeeOrder("Mocha", Size.SMALL, false, false);
		
		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal());
		System.out.println(bev.getNumOfAlcoholDrink()); // 0
		if (bev.isValidAge(bev.getCurrentOrder().getCustomer().getAge())) {
			System.out.println("Should not get to here!!!");
			bev.processAlcoholOrder("mohito", Size.MEDIUM);
		} else
			System.out.println("Age not appropriate for alcohol drink!!"); 

		cusOrderNum = bev.getCurrentOrder().getOrderNum();

		if (bev.findOrder(cusOrderNum) != -1)
			System.out.println("Total on the Order:" + bev.totalOrderPrice(cusOrderNum)); 
		else {
			System.out.println("Order not found. Should no get to here!!");
		}

		int numOfFruits = 8;
		if (bev.isMaxFruit(numOfFruits)) {
			System.out.println("Maximum number of fruits\n"); 
		} 
		else {
		numOfFruits = 4;
		}
		
		bev.processSmoothieOrder("Abdul's boost", Size.LARGE, numOfFruits, false);
		System.out.println("Total on the Order:" + bev.getCurrentOrder().calcOrderTotal());
		System.out.println("Total amount for all orders:" + bev.totalMonthlySale()); 
}
}
