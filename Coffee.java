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
public class Coffee extends Beverage{

	private boolean Extra_Shot; //if true add .50;
	private boolean Syrup; //if yes add .50;
	private final double EXTRASHOTADD = 0.5;
	private final double SYRUPADD = 0.5;
	
	public Coffee(String Bevname, Size Bevsize,boolean Extra_Shot, boolean Syrup) {
		super(Bevname, Bevsize, Type.COFFEE);
		this.Extra_Shot = Extra_Shot;
		this.Syrup = Syrup;
	}

	public boolean IsExtra_Shot() {
		return Extra_Shot;
	}

	public boolean IsSyrup() {
		return Syrup;
	}

	@Override
	public double calcPrice() {
		
			
		double totalPrice = 0;
		totalPrice+= getBASE_PRICE();
		if(getBevsize() == Size.MEDIUM) {
			totalPrice += (super.getSIZE_PRICE());
		}
		else if(getBevsize()== Size.LARGE) {
			totalPrice += (super.getSIZE_PRICE()*2);
		}
		else {
		}
		
		if(Extra_Shot && Syrup) {
			totalPrice+= EXTRASHOTADD + SYRUPADD;
		} 
		else if(Extra_Shot || Syrup) {
			totalPrice+=0.50;
		}
		
		return totalPrice;
	}
	
		
		
		@Override
	public String toString() {
			String str = "";
			
			str += super.toString();
			
			if(Extra_Shot) {
				str+= "\nExtra Shot";
			} 
			else {
				str+= "\nNo Extra Shot";
			}
			if(Syrup) {
				str+="\nExtra Syrup";
			} 
			else {
				str+= "\nNo Extra Syrup";
			}
			
			str += "\nPrice: $" + calcPrice();
			
			return str;
		}
	

		@Override
		public boolean equals(Object o) {
			Coffee anothercof = (Coffee) o;
			return ((super.equals(anothercof)) && (this.Extra_Shot == anothercof.IsExtra_Shot()) &&(this.Syrup == anothercof.IsSyrup()));
		}
			
}
