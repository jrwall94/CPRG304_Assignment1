package utilities;
import products.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Convert a file to an array
 */
public class FileToArray {

	/**
	 * Takes a filename as a string, constructs an array of Products from 
	 * the information inside the file. Throws appropriate errors when
	 * the file is not in the correct format.
	 * @param filename The filename or path to the file
	 * @return An array of Products parsed from the file
	 */
	public static Product[] fileToArray(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));

			//first line of the file is the number of products, this becomes the size of the array
			int count = Integer.parseInt(input.nextLine().trim());
			Product[] products = new Product[count];

			//every line after the first is one product, scanner reads one word at a time and skips the spaces
			for (int i = 0; i < count; i++) {
				String type = input.next(); //product type word from the file
				double originalPrice = Double.parseDouble(input.next()); //first number is the original price
				double updatedPrice = Double.parseDouble(input.next()); //second number is the updated price

				products[i] = createProduct(type, originalPrice, updatedPrice); //create the matching product and store it in the array
			}

			input.close(); //done reading, close the file
			return products; //send the filled array back to AppDriver

		} 
		
		catch (FileNotFoundException e) {
			System.err.println("File does not exist: " + filename);
		} 
		
		catch (NoSuchElementException e) {
			System.err.println("Error: the file has less products than the first line says");
		} 
		
		catch (NumberFormatException e) {
			System.err.println("Error: the file contains a value that isn't a valid");
		} 
		
		catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		catch (NullPointerException e) {
			System.err.println("Error: No filename given");
		}
		
		return null; 
	}

	//file uses plural words (Dresses), classes are singular (Dress), switch picks the matching subclass
	private static Product createProduct(String type, double originalPrice, double updatedPrice) {
		switch (type) {
			case "Jeans":   return new Jeans(originalPrice, updatedPrice);
			case "TShirts": return new TShirt(originalPrice, updatedPrice);
			case "Skirts":  return new Skirt(originalPrice, updatedPrice);
			case "Dresses": return new Dress(originalPrice, updatedPrice);
			case "Shorts":  return new Shorts(originalPrice, updatedPrice);
			case "Jackets": return new Jacket(originalPrice, updatedPrice);
			case "Shoes":   return new Shoes(originalPrice, updatedPrice);
			default:
				//type in the file is not one of the 7 products
				throw new IllegalArgumentException("Unknown product type in file: " + type);
		}
	}

}