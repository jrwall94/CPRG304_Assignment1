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
		
		//Call the appropriate sorting method. Track the amount of time this takes in milliseconds
		long startTime = 0, endTime = 0;
		String sortString = null;
		
		//TODO: Change testArray to productArray when FileToArray is implemented
		switch (sortAlgorithm) {
			case ("b"):
				sortString = "Bubble";
				startTime = System.nanoTime();
				BubbleSort.sort(productArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("s"):
				sortString = "Selection";
				startTime = System.nanoTime();
				SelectionSort.selectionSort(productArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("i"):
				sortString = "Insertion";
				startTime = System.nanoTime();
				InsertionSort.insertionSort(productArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("m"):
				sortString = "Merge";
				startTime = System.nanoTime();				
				MergeSort.mergeSort(productArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("q"):
				sortString = "Quick";
				startTime = System.nanoTime();
				QuickSort.quickSort(productArray, comparator);
				endTime = System.nanoTime();
				break;
			case ("z"):
				sortString = "Custom";
				startTime = System.nanoTime();
				CustomSort.heapSort(productArray, comparator);
				endTime = System.nanoTime();
				break;
		}
		
		//Display the results to the console
		double milliTime = (endTime - startTime) / 1000000.0;
		System.out.println(sortString + " Sort run time was: " + milliTime + " milliseconds");
		System.out.println("Final Array:");
		
		if (productArray.length <= 10) {
			for (int i = 0; i < productArray.length; i++) {
				System.out.print(i + "-th element:\t" + productArray[i].getClass() + "\t");
				switch (compareType) {
				case "o":
					System.out.println("Original: " + productArray[i].getOriginalPrice());
					break;
				case "u":
					System.out.println("Updated: " + productArray[i].getUpdatedPrice());
					break;
				case "d":
					System.out.println("Real Difference: " + productArray[i].calcRealDiff());
					break;
				}
			
			}
		}
		else if (productArray.length <= 1000) {
			//TODO: Show the first and last element with different formatting
			for (int i = 0; i < productArray.length; i=i+100) {
				System.out.print(i + "-th element:\t" + productArray[i].getClass() + "\t");
				switch (compareType) {
				case "o":
					System.out.println("Original: " + productArray[i].getOriginalPrice());
					break;
				case "u":
					System.out.println("Updated: " + productArray[i].getUpdatedPrice());
					break;
				case "d":
					System.out.println("Real Difference: " + productArray[i].calcRealDiff());
					break;
				}
			}
		}
		else {
			//TODO: Show first and last element with different formatting
			for (int i = 0; i < productArray.length; i=i+1000) {
				System.out.print(i + "-th element:\t" + productArray[i].getClass() + "\t");
				switch (compareType) {
				case "o":
					System.out.println("Original: " + productArray[i].getOriginalPrice());
					break;
				case "u":
					System.out.println("Updated: " + productArray[i].getUpdatedPrice());
					break;
				case "d":
					System.out.println("Real Difference: " + productArray[i].calcRealDiff());
					break;
				}
			}
		}

	}

}
