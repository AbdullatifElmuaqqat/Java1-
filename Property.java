
public class Property {
	//property name, city, rental amount, owner, and plot
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	Plot plot;
	
	public Property() {
		
		this.plot = new Plot(0, 0, 1, 1);
		
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot=new Plot();
		
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
	}

	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);

		
	}
	

	public Plot getPlot() {
		return plot;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}

	public String getCity() {
		return this.city;
	}

	public double getRentAmount() {
		return this.rentAmount;
	}

	public String getOwner() {
		return this.owner;
	}

	@Override
	//[property name],[ city],[ owner],[ rental amount] 
	public String toString() {
		return getPropertyName() + "," + getCity() + "," + getOwner() + "," + getRentAmount();
	}

}
