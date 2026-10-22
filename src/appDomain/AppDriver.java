package appDomain;

import products.*;
import utilities.*;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 *  	This includes file name, compare type, and sorting algorithm
	 */
	public static void main( String[] args )
	{
		
		//Set sorting method, compare type, and file name based on user input
		
		String fileName = null, compareType = null, sortAlgorithm = null;
		
		//TODO: Check for Index out of bounds exceptions?
		
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				switch (arg.toLowerCase().charAt(1)) {
					case 'f':
						fileName = arg.substring(2);
						break;
					case 't':
						//Read more than just charAt(2) to better deal with incorrect inputs
						compareType = arg.substring(2);
						break;
					case 's':
						sortAlgorithm = arg.substring(2);
						break;
				}
			}
		}
		
		
		//Load array from text file by calling FileToArray() from the utilities package
		Product[] productArray = FileToArray.fileToArray(fileName);
		
		//Array for testing only. Delete after FileToArray has been implemented ***********************
		Product[] testArray = new Product[10];
		testArray[0] = new Jeans(54.46, 63.25);
		testArray[1] = new Dress(16.67, 20.82);
		testArray[2] = new Shorts(79.82, 83.5);
		testArray[3] = new Jeans(92.99, 169.9);
		testArray[4] = new Jacket(75.95, 104.97);
		testArray[5] = new Shorts(48.02, 70.71);
		testArray[6] = new Shorts(20.86, 68.57);
		testArray[7] = new Shorts(44.98, 117.02);
		testArray[8] = new Shorts(77.81, 176.19);
		testArray[9] = new Jacket(70.01, 143.2);
		//**********************************************************************************************
		
		//Call the appropriate sorting method. Track the amount of time this takes in milliseconds
		long startTime = 0, endTime = 0;
		System.out.println("Original Array: ");
		for (Product item : testArray) {
			System.out.println(item.getClass() + " - " + item.getOriginalPrice() + " " + item.getUpdatedPrice());
		}
		
		switch (sortAlgorithm) {
			case ("b"):
				startTime = System.nanoTime();
				//Bubble sort
				endTime = System.nanoTime();
				break;
			case ("s"):
				startTime = System.nanoTime();
				//Selection sort
				endTime = System.nanoTime();
				break;
			case ("i"):
				startTime = System.nanoTime();
				//Insertion sort
				endTime = System.nanoTime();
				break;
			case ("m"):
				startTime = System.nanoTime();
				//TODO: Change testArray to productArray when FileToArray is implemented
				MergeSort.mergeSort(testArray);
				endTime = System.nanoTime();
				break;
			case ("q"):
				startTime = System.nanoTime();
				//Quick sort
				endTime = System.nanoTime();
				break;
			case ("z"):
				startTime = System.nanoTime();
				//Custom sort
				endTime = System.nanoTime();
				break;
		}
		
		//Display the results to the console
		double milliTime = (endTime - startTime) / 1000000.0;
		System.out.println("The sorting algorithm executed in " + milliTime + " milliseconds");
		System.out.println("Final Array: ");
		for (Product item : testArray) {
			System.out.println(item.getClass() + " - " + item.getOriginalPrice() + " " + item.getUpdatedPrice());
		}

	}

}
