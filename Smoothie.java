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
public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean addProtein;
	private final double ADDPROTEIN = 1.50;
	private final double FRUIT = 0.50;

	public Smoothie(String Bevname, Size Bevsize, int numOfFruits, boolean addProtein) {
		super(Bevname, Bevsize, Type.SMOOTHIE);
		this.addProtein = addProtein;
		this.numOfFruits = numOfFruits;
	}

	@Override
	public double calcPrice() {
		double i = 0;
		double totalPrice = 0;
		totalPrice+= super.getBASE_PRICE();
		if(super.getBevsize() == Size.MEDIUM) {
			totalPrice += (super.getSIZE_PRICE());
		}
		else if(super.getBevsize() == Size.LARGE) {
			totalPrice += (super.getSIZE_PRICE()*2);
		}
		else {
		}
		
		while (i<getNumOfFruits()) {
			totalPrice+=FRUIT;
			i++;
		}
		
		if(IsAddProtien() == true) {
			totalPrice+=ADDPROTEIN;
		}
		
		return totalPrice;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		
		str += super.toString();
		
		if(IsAddProtien()) {
			str+= "\nProtein added";
		}
		else {
			str+= "\nProtein isn't added";
		}
		
		str+= "\nNumber of friuts added: " + getNumOfFruits();
		
		str += "\nprice: $" + calcPrice();
		
		return str;
		
	}
	
	public int getNumOfFruits() {
		return this.numOfFruits;
	}

	public boolean IsAddProtien() {
		return this.addProtein;
	}
	
	
	@Override 
	public boolean equals(Object o) {
		Smoothie anothersmo = (Smoothie) o; 
				if((super.equals(anothersmo)) && (anothersmo.getNumOfFruits() == getNumOfFruits()) 
						&& (IsAddProtien() == anothersmo.IsAddProtien())) {
					return true;
				}
				else {
					return false;
				}
	}
	
}
