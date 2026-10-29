package appDomain;

import products.*;
import utilities.*;

import java.util.Comparator;

import exception.InvalidCompareTypeException;
import exception.InvalidSortingAlgorithmException;
import external.*;

/**
 * <p>
 * This application driver code is the entry point for the
 * complexity and sorting assignment developed for the CPRG304 
 * class at SAIT. The following flags can be used to run it:
 * <ul>
 * <li>-t: Compare type</li>
 * <ul>
 * <li>o: Original value</li>
 * <li>u: Updated value</li>
 * <li>d: Calculated difference</li>
 * </ul>
 * <li>-s: Sorting algorithm</li>
 * <ul>
 * <li>b: Bubble sort</li>
 * <li>s: Selection sort</li>
 * <li>i: Insertion sort</li>
 * <li>m: Merge sort</li>
 * <li>q: Quick sort</li>
 * <li>z: Custom sort (Heap sort)</li>
 * </ul>
 * <li>-f: File name</li>
 * </ul>
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
		
		try {
			for (String arg : args) {
				if (arg.charAt(0) == '-') {
					switch (arg.toLowerCase().charAt(1)) {
						case 'f':
							fileName = arg.substring(2);
							break;
						case 't':
							//Read more than just charAt(2) to better deal with incorrect inputs
							compareType = arg.substring(2).toLowerCase();
							break;
						case 's':
							sortAlgorithm = arg.substring(2).toLowerCase();
							break;
					}
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("ERROR: Missing a value after a flag (-)");
		}
		
		//Assign the correct comparator
		Comparator<Product> comparator = null;
		
		//Use the comparable if sorting by real difference
		try {
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
					throw new InvalidCompareTypeException();
			}
		} catch (NullPointerException e) {
			System.out.println("ERROR: No compare type was given. Please use the -t flag");
			return;
		} catch (InvalidCompareTypeException e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		//Load array from text file by calling FileToArray() from the utilities package
		Product[] productArray = FileToArray.fileToArray(fileName);
		
		if (productArray == null) {
			return;
		}
		
		//Call the appropriate sorting method. Track the amount of time this takes in milliseconds
		long startTime = 0, endTime = 0;
		String sortString = null;
		
		try {
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
					sortString = "Heap";
					startTime = System.nanoTime();
					CustomSort.heapSort(productArray, comparator);
					endTime = System.nanoTime();
					break;
				default:
					throw new InvalidSortingAlgorithmException();
			} 
		} catch (InvalidSortingAlgorithmException e) {
			System.out.println(e.getMessage());
			return;
		} catch (NullPointerException e) {
			System.out.println("No sorting algorithm was given. Please use the -s flag");
			return;
		}
		
		System.out.println("Sorted Array:");
		
		//Show first element
		System.out.printf("%-20s %-25s \t", "First element is: ", productArray[0].getClass());
		System.out.println(printHelper(compareType, productArray, 0));
		
		//Output for a short list
		if (productArray.length <= 10) {
			//Manually print 2nd and 3rd elements rather than make a suffix switch-case for only two outliers
			System.out.printf("%-20s %-25s \t", "2-nd element:", productArray[1].getClass());
			System.out.println(printHelper(compareType, productArray, 1));
			System.out.printf("%-20s %-25s \t", "3-rd element:", productArray[2].getClass());
			System.out.println(printHelper(compareType, productArray, 2));
			for (int i = 3; i < productArray.length - 1; i++) {
				System.out.printf("%-20s %-25s \t", (i+1) + "-th element:", productArray[i].getClass());
				System.out.println(printHelper(compareType, productArray, i));
			}
		}
		//Output for a medium list
		else if (productArray.length <= 1000) {
			for (int i = 99; i < productArray.length-100; i=i+100) {
				System.out.printf("%-20s %-25s \t", (i+1) + "-th element:", productArray[i].getClass());
				System.out.println(printHelper(compareType, productArray, i));
			}
		}
		//Output for a long list - Show roughly 20 equally spaced elements to avoid overwhelming output
		else {
			for (int i = (productArray.length/20)-1; i < productArray.length-(productArray.length/20); i=i+(productArray.length/20)) {
				System.out.printf("%-20s %-25s \t", (i+1) + "-th element:", productArray[i].getClass());
				System.out.println(printHelper(compareType, productArray, i));
			}
		}
		
		//Show last element
		System.out.printf("%-20s %-25s \t", "Last element is:", productArray[productArray.length-1].getClass());
		System.out.println(printHelper(compareType, productArray, productArray.length-1));
		
		//Display the timing results to the console
		double milliTime = (endTime - startTime) / 1000000.0;
		System.out.println(sortString + " Sort run time was: " + milliTime + " milliseconds");
	}
	
	/**
	 * A function to help with looking at the comparison type and show the correct variable
	 * @param compareType The type of comparison being done by the main function
	 * @param productArray The array of products being processed by the main function
	 * @param index The current index of the array being looked at
	 * @return outputString The string to be printed by the main function
	 */
	private static String printHelper(String compareType, Product[] productArray, int index) {
		String outputString = "";
		switch (compareType) {
		case "o":
			outputString = "Original: " + productArray[index].getOriginalPrice();
			break;
		case "u":
			outputString = "Updated: " + productArray[index].getUpdatedPrice();
			break;
		case "d":
			outputString = "Real Difference: " + productArray[index].calcRealDiff();
			break;
		}
		return outputString;
		
	}

}
