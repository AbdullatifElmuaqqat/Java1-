package Project5;

/*
 * Class: CMSC203 
 * Instructor: Ghary Thai
 * Description: Create a utility class that will calculate holiday bonuses given a 
 * ragged array of doubles which represent the sales for each store in each category.
 * Due: 11/12/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullatif Elmuaqqat
*/

public class HolidayBonus {
	
	public HolidayBonus() {
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data) {
		
		double [] holidayBonus = new double [data.length];
		
		double low = 1000, hight = 5000, others = 2000;
		
		for(int i = 0; i<data.length; i++) {
			for(int y = 0; y<data[i].length;y++) {
				if(data[i][y]>0) {
					
				if(data[i][y] == data[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, y)][y]) {
					holidayBonus[i] += hight; 
				}
				else if (data[i][y] == data[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, y)][y]) {
					holidayBonus[i] += low;
				} 
				else {
					  holidayBonus[i] += others;
				}
				
			}
		}
		}
		return holidayBonus;
}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double sum= 0;
		
		double [] holidayBonus = calculateHolidayBonus(data);
		
			
			for(int i = 0; i<data.length;i++) {
				sum+=holidayBonus[i];
			}
			
			return sum;
	}
}
