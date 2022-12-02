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

public class Alcohol extends Beverage {

	private boolean OfferedInWeekends;
	private final double ADDWEEKENDS = 0.60;
	
	public Alcohol(String Bevname, Size Bevsize,boolean OfferedInWeekends) {
		super(Bevname, Bevsize, Type.ALCOHOL);
		this.OfferedInWeekends = OfferedInWeekends;
	}

	@Override
	public double calcPrice() {
		double totalPrice = 0;
		totalPrice+= getBASE_PRICE();
		if(getBevsize() == Size.MEDIUM) {
			totalPrice += (super.getSIZE_PRICE());
		}
		else if(getBevsize() == Size.LARGE) {
			totalPrice += (super.getSIZE_PRICE()*2);
		}
		else {
		}
		
		if(OfferedInWeekends) {
			totalPrice+=ADDWEEKENDS;
		}
		
		return totalPrice;
	}

	
	
	@Override
	public String toString() {
		String str = "";
		
		str+= super.toString();
		
		if(OfferedInWeekends) {
			str+= "\nOffered in the weekend";
		} 
		else {
			str+= "\nNot offered in the weekend";
		}
		
		str+= "\nPrice: $" + calcPrice();
		
		return str;
	}

	@Override 
		public boolean equals(Object o)
		{
			Alcohol anotheralco = (Alcohol) o;
			return ((super.equals(anotheralco)) && 
					(this.OfferedInWeekends == anotheralco.IsOfferedInWeekends()));
		}

		public boolean IsOfferedInWeekends() {
			return OfferedInWeekends;
		}
		
		
}
