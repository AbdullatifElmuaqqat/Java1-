import java.util.ArrayList;
import java.util.Random;
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
public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	Customer cutomer;
	private Type listofBev;
	private ArrayList <Beverage> beverages;
	
	public  Order(int Orderti, Day od,Customer cus) {
		this.orderTime = Orderti; 
		this.orderDay = od;
		this.cutomer = new Customer(cus);
		//this.cutomer = cus;
		beverages = new ArrayList<>();
		this.orderNum = this.RandomNumGenerator();
	}
	public int RandomNumGenerator() {
		
		int randomNumber = ( int )( Math. random() * 90000 ); 
		if( randomNumber <= 10000 ) {
			randomNumber = randomNumber + 10000; 
		}
		
		return randomNumber;
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		if(orderNum == anotherOrder.getOrderNum()) {
			return 0;
		} else if(orderNum> anotherOrder.getOrderNum()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	@Override
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY ) {
			return true;
		} else {
		return false;
	}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffe = new Coffee(bevName, size,extraShot,extraSyrup);
		beverages.add(coffe);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean weekends = false;
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			weekends = true;
		} else {
			weekends = false;
		}
		
		Alcohol alcohol = new Alcohol(bevName, size, weekends);
		beverages.add(alcohol);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie
				(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
	}

	@Override
	public double calcOrderTotal() {
		int total = 0;
		for(Beverage x:beverages) {
			total+=x.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		
		for(Beverage x: beverages) {
			if(type == x.getBevtype()) {
		count ++;
	}
		}
		
		return count;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public Day getOrderDay() {
		return orderDay;
	}
	public Customer getCustomer() {
		return new Customer(cutomer);
	}
	public Type getListofBev() {
		return listofBev;
	}
	
	
	
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}
	
	
	@Override
	public String toString() {
		 String str = "";
		str += "order number: " + getOrderNum() + "\n" + "order time: "+
		getOrderTime() + "\n" + "order day: " + getOrderDay() + "\n" +
		cutomer.toString() + "\n";
		
		for(Beverage b : beverages) {
			str += b.toString();
		}
		
		str += "\nTotal: $" + this.calcOrderTotal();
		
		return str;
	}
	
//	public void setOrderTime(int orderTime) {
//		this.orderTime = orderTime;
//	}
//	public void setOrderDay(Day orderDay) {
//		this.orderDay = orderDay;
//	}
//	public void setOrderNo(int orderNo) {
//		this.orderNum = orderNo;
//	}
//	
//	public void setBeverages(ArrayList<Beverage> beverages) {
//		this.beverages = beverages;
//	}
//	

}
