package appDomain;

import products.*;
import utilities.*;

import java.util.Comparator;

import external.*;

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
		OriginalCompare oc = new OriginalCompare();
		UpdatedCompare uc = new UpdatedCompare();
		
		
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
		
		//Assign the correct comparator
		Comparator<Product> comparator = null;
		
		//Use the comparable if "d"
		switch (compareType) {
			case "o":
				comparator = oc;
				break;
			case "u":
				comparator = uc;
				break;
			case "d":
				comparator = Comparator.naturalOrder();
				break;
			default:
				//TODO: Throw an error if it is not one of these options
				break;
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
		String sortString = null;
		
		System.out.println("Original Array: ");
		for (Product item : testArray) {
			System.out.println(item.getClass() + " - " + item.getOriginalPrice() + " " + item.getUpdatedPrice());
		}
		
		//TODO: Change testArray to productArray when FileToArray is implemented
		switch (sortAlgorithm) {
			case ("b"):
				sortString = "Bubble";
				startTime = System.nanoTime();
				//Bubble sort
				endTime = System.nanoTime();
				break;
			case ("s"):
				sortString = "Selection";
				startTime = System.nanoTime();
				SelectionSort.selectionSort(testArray);
				endTime = System.nanoTime();
				break;
			case ("i"):
				sortString = "Insertion";
				startTime = System.nanoTime();
				//Insertion sort
				endTime = System.nanoTime();
				break;
			case ("m"):
				sortString = "Merge";
				startTime = System.nanoTime();				
				MergeSort.mergeSort(testArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("q"):
				sortString = "Quick";
				startTime = System.nanoTime();
				QuickSort.quickSort(testArray);
				endTime = System.nanoTime();
				break;
			case ("z"):
				sortString = "Custom";
				startTime = System.nanoTime();
				//Custom sort
				endTime = System.nanoTime();
				break;
		}
		
		//Display the results to the console
		double milliTime = (endTime - startTime) / 1000000.0;
		System.out.println(sortString + " Sort run time was: " + milliTime + " milliseconds");
		System.out.println("Final Array:");
		
		if (testArray.length <= 10) {
			for (int i = 0; i < testArray.length; i++) {
				System.out.println(i + "-th element:\t" + testArray[i].getClass() + "\t Original: " + testArray[i].getOriginalPrice() + "\tUpdated: " + testArray[i].getUpdatedPrice());
			}
		}
		else if (testArray.length <= 1000) {
			
		}

	}

}
