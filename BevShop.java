import java.util.ArrayList;
/*
 * Class: CMSC203 
 * Instructor: Ghary Thai
 * Description: Creating a software that takes orders of Beverages for Beverage shop.
 * Due: 12/05/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullatif Elmuaqqat
*/
public class BevShop implements BevShopInterface{
	 
	private ArrayList<Order> orders;
	private int Currentindex;
	private int numberOfAlcoholDrink = 0;
	
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		if(MAX_TIME < time || MIN_TIME > time) {
		return false;
		}
		return true;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits>MAX_FRUIT) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if(numberOfAlcoholDrink>3)
			return false;
		
		return true;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return numberOfAlcoholDrink;
	}

	@Override
	public boolean isValidAge(int age) {
		if(age<=getMinAgeForAlcohol()) {
			return false;
		}
		return true;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer custo = new Customer(customerName, customerAge);
		Order ord = new Order(customerAge, day, custo); 
		orders.add(ord);
		Currentindex =  orders.indexOf(ord);
		numberOfAlcoholDrink = 0;
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage
		(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		if(numberOfAlcoholDrink <= getMaxOrderForAlcohol()) {
		getCurrentOrder().addNewBeverage(bevName, size);
		numberOfAlcoholDrink++;
		}
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage
		(bevName, size, numOfFruits, addProtein);	
	
	}

	@Override
	public int findOrder(int orderNo) {
		
		for(int i = 0; i<orders.size();i++) {
			if(orders.get(i).getOrderNum() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double total =0;
		
		for(Order x: orders) {
			if(x.getOrderNum() == orderNo) {
				for(Beverage b: x.getBeverages()) {
					total+=b.calcPrice();
				}
			}
		}
		return total;
	}

	@Override
	public double totalMonthlySale() {
		int total = 0;
		
		for(Order x: orders) {
			for(Beverage b:x.getBeverages()) {
				total += b.calcPrice();
			}
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		
		return orders.get(Currentindex);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		for(int i = 0; i < orders.size(); i++) {
			for(int j =orders.size()- 1; j > i;j--) {
				if(orders.get(i).compareTo(orders.get(j)) == 1) {
					Order temp = orders.get(i);
					orders.set(i, orders.get(j));
					orders.set(j, temp);
				}

				}
			}
		}

	@Override
	public String toString() {
		String str = " ";
		str += "Monthly Orders\n";
        
        for (Order x : orders) {
                str += x.toString();
        }
        str += "Total Sale: " + totalMonthlySale();
        
        return str;
	}
}
