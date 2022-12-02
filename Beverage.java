
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

abstract class Beverage{
	private String Bevname;
	private Size Bevsize;
	private  Type Bevtype;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0; //add dollar to go from size to size.
	
	public Beverage (String Bevname, Size Bevsize, Type Bevtype) {
		this.Bevname = Bevname;
		this.Bevsize = Bevsize;
		this.Bevtype = Bevtype;
	}
	
	abstract public double calcPrice(); 
	
	
	
	@Override
	public String toString() {
		return "Beverage name: " + this.Bevname + "\n" + "Beverage size: " + this.Bevsize;
	}
	
	@Override
	public boolean equals(Object o) {
		Beverage anotherbev = (Beverage) o;
		return ((this.Bevname.equals(anotherbev.getBevname()) && (this.Bevsize == anotherbev.getBevsize()) && (this.Bevtype  == anotherbev.getBevtype())));
	}


	public String getBevname() {
		return this.Bevname;
	}

	public Size getBevsize() {
		return this.Bevsize;
	}


	public Type getBevtype() {
		return this.Bevtype;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}


	
}
