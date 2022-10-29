/*
 * Class: CMSC203 
 * Instructor:
 * Description: A property management company manages individual properties they
 *  will build to rent, and charges them a management fee 
 *  as the percentages of the monthly rental amount. 
 * Due: 10/29/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullatif Elmuaqqat
*/

public class ManagementCompany {

	static final int MAX_PROPERTY = 5; //Max property.
	static final int MGMT_DEPTH = 10; // Manegment screen depth 10.
	static final int MGMT_WIDTH = 10; // Managment screen width 10.
	
	Plot plot; //plot object
	private Property[] Properties; //property array
	private int numberOfProperties; //number of properties
	private String Name; // Managment name
	private String TaxID; // Managment Tax Id
	private double mgmFee; // Managment fees
	
	//ManagementCompany instructor with non-args
	public ManagementCompany() {
		this.Name = "";
		this.TaxID = "";
		this.mgmFee = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.Properties = new Property[MAX_PROPERTY];
		}
	
	//ManagementCompany constructor with only name and id and managment fees
	public ManagementCompany(String name, String taxID, double mgmFee) {
	
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.Name = name;
		this.TaxID = taxID;
		this.mgmFee = mgmFee; 
		this.Properties = new Property[MAX_PROPERTY];

	}
	
	//ManagementCompany constructor with name and id and managment fees + and x y width and depth of a plot.
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth){
		this.plot = new Plot(x,y,width,depth);
		this.Name = name;
		this.TaxID = taxID;
		this.mgmFee =mgmFee; 
		this.Properties = new Property[MAX_PROPERTY];

	}

	//ManagementCompany constructor for another object, aggregation.
	public ManagementCompany(ManagementCompany otherCompany) {
		this.plot = new Plot(otherCompany.plot);
		this.Properties = new Property[MAX_PROPERTY];
		this.Name = otherCompany.Name;
		this.TaxID = otherCompany.TaxID;
		this.mgmFee = otherCompany.mgmFee; 
	}
	
	/**
	 * 
	 * @param property
	 * @return
	 */
	public int addProperty(Property property) {
		
		//-2 if the Property object is null
		 if (this.Properties== null) {
			return -2;
		}
		
		//-3 if management company does not encompass the property plot
		else if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		//-4 if property plot overlaps ANY of properties in array.
		for(int i = 0; i < Properties.length; i++) {
			if(this.Properties[i] != null) {
				if(this.Properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
		 }
			}
		 //otherwise return the index of the array where the property was added.
		 else {
			 this.Properties[i] = property;
			 return i;
		 }
		}
		
		return -1;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param city
	 * @param rent
	 * @param ownerName
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String propertyName, String  city, double rent , String ownerName, int x, int y, int width, int depth){
	
		return addProperty(new Property(propertyName, city, rent, ownerName,x,y,width,depth));
	}
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		
		return addProperty( new Property(name, city, rent, owner));
	}
	
	/**
	 * 
	 * @return the total amount of rent for all properties
	 */
	public double getTotalRent() {
		
		double totalrent = 0;
		 
		for(int i = 0; i<Properties.length;i++) {
			if(this.Properties[i]!= null) {
			totalrent +=Properties[i].getRentAmount();
		}
	}
		return totalrent;
		
	}

	/**
	 *  erase the last element from the array
	 */
	public void removeLastProperty() {
		
		Properties[Properties.length - 1] = null;

	}
	
	/**
	 * 
	 * @return true if the properties greater than the max properties and false if not.
	 */
	public boolean isPropertiesFull() {
		
		 this.numberOfProperties = Properties.length;
		if(this.numberOfProperties > MAX_PROPERTY) {
			return  true;
		} 
		return false;
	}
	
	/**
	 * 
	 * @return how many properties their in the array
	 */
	public int getPropertiesCount(){
		 int count = 0;
		for(int i = 0; i<Properties.length; i++) {
			if(this.Properties[i]!= null) {
			count++;
		}

	}
		return count;
	}

	/**
	 * 
	 * @return the highest property who has the highest rent rate
	 */
	public Property getHighestRentPropperty() {
		
		int propind = 0;
		double highest = 0;		
	        for (int i = 1; i < Properties.length; i++){
	         if (this.Properties[i]!= null && Properties[i].getRentAmount() > highest)
	         {
	        	 highest = Properties[i].getRentAmount();
	        	 propind = i; 
	         }
	}
	        return Properties[propind];
	}
	
	/**
	 * 
	 * @return if the manegment fees above 100 and below 0 false, otherwise return true.
	 */
	public boolean isMangementFeeValid() {
		//checks if the management company has a valid (between 0-100) fee
		if(getMgmFee() >= 0 && getMgmFee() <= 100) {
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @return the plot you created
	 * 	 */
	public Plot getPlot() {
		return new Plot(plot);
	}

//	public void setPlot(Plot plot) {
//		this.plot = plot;
//	}
	
	/**
	 * 
	 * @return the properties the user created
	 */
	public Property[] getProperties() {
		return Properties;
	}

//	public void setProperties(Property[] properties) {
//		Properties = properties;
//	}
//
	/**
	 * 
	 * @return the name the user input
	 */
	public String getName() {
		return Name;
	}
//
//	public void setName(String name) {
//		Name = name;
//	}

	/**
	 * 
	 * @return the tax id the user input
	 */
	public String getTaxID() {
		return TaxID;
	}

//	public void setTaxID(String taxID) {
//		TaxID = taxID;
//	}

	/**
	 * 
	 * @return the managment fees
	 */
	public double getMgmFee() {
		return mgmFee;
	}

//	public void setMgmFee(double mgmFee) {
//		this.mgmFee = mgmFee;
//		}
	/**
	 * create a tostring method that takes display the values in GUi.
	 */
	
	@Override
	public String toString() {
		
		String string = "";
		string += "List of the properties for " + this.getName() + ", taxID: " + this.getTaxID() + "\n" 
		+ "______________________________________________________\n";
		
		for(int i = 0; i < Properties.length; i++){
			string+= Properties[i] + "\n";
		}
		
		string+= "______________________________________________________\n"
				+ "\n"
				+ "total management Fee: " + (this.getTotalRent() * (this.mgmFee/100));
		return string;
}
}