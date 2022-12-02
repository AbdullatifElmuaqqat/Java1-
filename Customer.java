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
public class Customer {
	private String name;
	private int age;
	
	public Customer(String n, int a) {
		this.age = a;
		this.name = n;
	}
	
	public Customer (Customer anotherCustomer) {
		this.age = anotherCustomer.age;
		this.name = anotherCustomer.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name: " + getName() + "\n" + "Age: " + getAge();
	}

	
	
	
}
