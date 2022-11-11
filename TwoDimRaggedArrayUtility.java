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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.sound.sampled.spi.AudioFileWriter;

public class TwoDimRaggedArrayUtility {

	final int ROW = 10;
	final int COL = 10;

	/**
	 * Deafult constructor
	 */
	public TwoDimRaggedArrayUtility() {

	}

	/**
	 * @param file
	 * @return the file information  
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		String[][] array = new String[10][];
		Scanner x = new Scanner(file);
		int rows = 0;
		// go inside a while loop to scan how many rows in the file.
		while (x.hasNext() && rows < array.length) {
			String line = x.nextLine();
			String[] tokens = line.split(" ");

			array[rows] = tokens;

			rows++;
		}

		double[][] dst = new double[rows][];
		for (int i = 0; i < rows; i++) {

			String[] str = array[i];
			double[] dtr = new double[str.length];
			int col = 0;

			for (String tt : str) {

				dtr[col++] = Double.parseDouble(tt);
			}
			dst[i] = dtr;

		}
		x.close();
		
		return dst;
	}
	
	/**
	 *
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		
		PrintWriter file = new PrintWriter(outputFile);
		
		for (int i = 0; i < data.length; i++) {
			for (int f = 0; f < data[i].length; f++) {
				file.print(data[i][f] + " ");
			}
			file.println();
		}
		
		file.close();
	}
	
	/**
	 * 
	 * @param data
	 * @return the total of the elements.
	 */

	public static double getTotal(double[][] data) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			for (int y = 0; y < data[i].length; y++) {
				total += data[i][y];
			}
		}
		return total;
	}

	/**
	 * 
	 * @param data
	 * @return the avarage of the regged arrays
	 */
	public static double getAverage(double[][] data) {
		double avarage;
		double total_index = 0;
		double total = getTotal((data));

		for (int y = 0; y < data.length; y++) {
			for (int i = 0; i < data[y].length; i++) {
				total_index++;
			}

		}

		avarage = total / total_index;
		return avarage;
	}
	/**
	 * 
	 * @param data
	 * @param row
	 * @return the total row element.
	 */

	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		return total;
	}

	/** 
	 * 
	 * @param data
	 * @param col
	 * @return the total colum element.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int i = 0; i < data.length; i++) {
			if(col< data[i].length) {
			total += data[i][col];
		}
	}
		return total;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return the highest element from the row.
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = Integer.MIN_VALUE;
		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > highest) {
				highest = data[row][i];
			}
		}

		return highest;
	}
	/**
	 * 
	 * @param data
	 * @param row
	 * @return the index that is highest from the row.
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double heighest = Double.MIN_VALUE;
		int index = -1;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] > heighest) {
				heighest = data[row][i];
				index = i;
			}
		}

		return index;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return the lowest element from the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = Double.MAX_VALUE;
		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return the index which is the lowest from the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		double LowestCol = Double.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if (row < data[i].length) {
			if (LowestCol > data[i][row]) {
				LowestCol = data[i][row];
				index = i;
			}
		}
		}
		return index;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return the highest element form the colum.
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double heighestCol = Double.MIN_VALUE;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
			if (heighestCol < data[i][col]) {
				heighestCol = data[i][col];
			}
		}
		}
		return heighestCol;
	}
 
	/**
	 * 
	 * @param data
	 * @param col
	 * @return the index of the highest element of the column.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double heighestCol = Double.MIN_VALUE;
		int index_highest = 0;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (heighestCol < data[i][col]) {
				heighestCol = data[i][col];
				index_highest = i;
			}
		}
	}
		return index_highest;
	}
	
	/**
	 * 
	 * @param data
	 * @param col
	 * @return the lowest element from the column.
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Integer.MAX_VALUE;
		
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					
				}
			}
		}

		return lowest;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return the index of the highest element of the column.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {

		int lowest_index =-1;
		double lowest = Integer.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] < lowest) {
					lowest = data[i][col];
					lowest_index = i;// lowest row
				}
			}
		}
		return lowest_index;
	}

		/**
		 * 
		 * @param data
		 * @return the highest element of the array.
		 */
	public static double getHighestInArray(double[][] data) {

		double highestArray = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int x = 0; x < data[i].length; x++) {
				if (highestArray < data[i][x]) {
					highestArray = data[i][x];
				}
			}
		}
		return highestArray;
	}

	/** 
	 * 
	 * @param data
	 * @return the lowest element of the array.
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestArray = data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int x = 0; x < data[i].length; x++) {
				if (lowestArray > data[i][x]) {
					lowestArray = data[i][x];
				}
			}
		}
		return lowestArray;
	}

}