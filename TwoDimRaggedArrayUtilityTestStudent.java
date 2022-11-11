package Project5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a TwoDimRaggedArrayUtility object.
 * 
 * @author Farnaz Eivazi
 * @version 7/13/2022
 * 
 */
public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet = {{4,3,1},{6,4},{5,2,9},{1,2}};
	private  double [][] dataSet2 = {{3,4},{6,4,2},{1,3,4},{8,5,2,1}};
	
	private  File inputfile,outputfile ;

	
	@Before
	public void setUp() throws Exception {
		outputfile = new File("TestFile2.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSet = dataSet2 = null;
		inputfile = outputfile = null;
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double arrays[][] = null;
		
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet2, outputfile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		
		//public double [][] dataSet2 = {{3,4}, {6,4,2},{1,3,4},{8,5,2,1}};
		arrays= TwoDimRaggedArrayUtility.readFile(outputfile);
		assertEquals(3, arrays[0][0],.001);
		assertEquals(4, arrays[0][1],.001);
		assertEquals(6, arrays[1][0],.001);
		assertEquals(4, arrays[1][1],.001);
		assertEquals(2, arrays[1][2],.001);
		assertEquals(1, arrays[2][0],.001);
		assertEquals(3, arrays[2][1],.001);
		assertEquals(4, arrays[2][2],.001);
		assertEquals(8, arrays[3][0],.001);
		assertEquals(5, arrays[3][1],.001);
		assertEquals(2, arrays[3][2],.001);
		assertEquals(1, arrays[3][3],.001);
	
	}
	
	
	@Test
	public void testReadFile() {
		double[][] array=null;
		try {
			inputfile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputfile);
			
			inFile.print("1 2 3\n" +
					"4 7 1\n" +
					"1 1" );
			inFile.close();
			
			array = TwoDimRaggedArrayUtility.readFile(inputfile );
			assertEquals(1, array[0][0],.001);
			assertEquals(2, array[0][1],.001);
			assertEquals(3, array[0][2],.001);
			assertEquals(4, array[1][0],.001);
			assertEquals(7, array[1][1],.001);
			assertEquals(1, array[1][2],.001);
			assertEquals(1, array[2][0],.001);
			assertEquals(1, array[2][1],.001);


		} catch (FileNotFoundException e) {
			fail("This should not have caused an FileNotFoundException");
		}

		try{
			assertEquals(0.0, array[1][3],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		}

		try{
			assertEquals(0.0, array[2][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testGetRowTotal() {
		assertEquals(10.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet,1),.001);
		assertEquals(8.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet,0),.001);
	}
	
	@Test
	public void testGetRTotal() {
		assertEquals(37.00,TwoDimRaggedArrayUtility.getTotal(dataSet),001);
	}
	
	@Test
	public void testGetAvarage() {
		assertEquals(3.7,TwoDimRaggedArrayUtility.getAverage(dataSet),001);
	}
	
	@Test 
	public void testgetColumnTotal() {
		assertEquals(16.00, TwoDimRaggedArrayUtility.getColumnTotal(dataSet, 0),001);
		assertEquals(11.00, TwoDimRaggedArrayUtility.getColumnTotal(dataSet, 1),001);
	}
	
	@Test 
	public void testgetHighestInRow() {
		assertEquals(6.00, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 1), 1);
		assertEquals(4.00, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 0), 1);
		assertEquals(9.00, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 2), 1);
		
	}
	
	@Test 
	public void testgetHighestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 0),001);
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 1),001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 2),001);
	}
	
	@Test 
	public void testgetLowestInRow() {
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 2),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 0),001);
		assertEquals(4,TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 1),001);
	}
	
	@Test
	public void testgetLowestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 0),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 1),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 2),001);
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 3),001);
	}
	
	@Test
	public void testgetHighestInColumn() {
		assertEquals(6,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 0),001);
		assertEquals(4,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 1),001);
		assertEquals(9,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 2),001);
	}
	
	@Test
	public void testgetHighestInColumnIndex(){
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 0),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 1),001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 2),001);
	}
	
	@Test
	public void testgetLowestInColumn() {
		//assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 0),001);
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 1),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 2),001);
	}
	@Test
	public void testgetLowestInColumnIndex() {
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 0),001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 1),001);
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 2),001);
	}
	
	@Test 
	public void testgetgetHighestInArray() {
		assertEquals(9,TwoDimRaggedArrayUtility.getHighestInArray(dataSet),001);
	}
	@Test 
	public void testgetgetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet),001);
	}
}