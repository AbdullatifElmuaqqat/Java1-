
public class Plot {

	private int x,y,width,depth; //Class attrubutions
	
	//create a non-arg for Plot
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	//constructor for the plot using a gving value
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	//constructor for another plot using diffrent values
	public Plot(Plot otherplot) {
		this.x= otherplot.x;
		this.y=otherplot.y;
		this.width = otherplot.width;
		this.depth = otherplot.depth;
	}
	
	//set the x value  
		public void setX(int x) {
			this.x = x;
		}
		//set the y value
		public void setY(int y) {
			this.y = y;
		}
		//set the width value
		public void setWidth(int width) {
			this.width = width;
		}
		//set depth value
		public void setDepth(int depth) {
			this.depth = depth;
		}
		// get the x value and retur it.
		public int getX() {
		return x;
	}
		// get the y value and retur it
		public int getY() {
		return y;
	}
		// get the depth value and retur it.
		public int getDepth() {
		return depth;
	}
		// get the width value and retur it.
		public int getWidth(){
		return width;
	}
	
	//Overlaps method that return false if the plot over lap the current plot.
	public boolean overlaps(Plot plot) {
		
		boolean overlaps = true;
		
		if(this.getY() + this.getDepth() <= plot.getY() || plot.getY() >= this.getY() + this.getDepth()){
			overlaps = false;
		}
		else if(this.getX() + this.getWidth() <= plot.getX() || plot.getX() >= this.getX() + this.getWidth()) {
			overlaps = false;
		}
		
		else {
			overlaps = true;
		}
		
		return overlaps;
	}
	
	public boolean encompasses(Plot plot) {
		
		if(this.getX() <= plot.getX() && this.getX() + width >= plot.getX() + plot.getWidth() 
		&& this.getY() <= plot.getY() && this.getY() + depth >= plot.getY() + plot.getDepth() ) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return this.getX() + "," + this.getY() + "," + this.getWidth() + "," + this.getDepth();
	}
	
	
}