// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

import java.util.Scanner;

/************************************************************/
/**
 * @author Felix Zapata.
 * Date: 3/04/2019
 */
 
/* UI class is implemented as an enum with the purpose of
 * defining a Singleton class. Using enums to define singletons
 * is described as the best way in Java for implementing this
 * design pattern.
 * The reason for UI for being a singleton is because multiple
 * instantiation of this class is not necessary and since it
 * will be used in multiple places along the code it is better
 * to proceed with a singleton.
 */
public enum UI {
	INSTANCE;
	
	/*
	 * Set the properties of the instance
	 */
	private Scanner myScanner = null;
	
	//----------------------- METHODS ---------------------------//
	
	/**
	 * Enum constructor
	 */
	private UI() {
		// Set my Scanner
		Scanner newScanner = new Scanner(System.in);
		this.setMyScanner(newScanner);
	}
	
	/**
	 * outputString method proceeds to print the provided String
	 * to screen.
	 * @param outputString: String which we desire to print to screen
	 */
	public void printToScreen(String outputString) {
		// Print the outputString to the Screen
		System.out.println(outputString);
	}

	/**
	 * inputScreen method returns the String input from the screen
	 * by the user
	 * @param userIndication: String indicating the pattern that has to be passed.
	 * @return String input by the user
	 */
	public String inputScreen(String userIndication) {
		
		printToScreen("\n Please input in fashion: " + userIndication + "\n");	// Print the userIndication to screen
		String output = this.getMyScanner().next();								// Extract the string	
		return output;															// Return the output

	}
	
	/**
	 * inputLineScreen method returns the String input from the screen
	 * by the user when he is supposed to enter a line
	 * @param userIndication: String indicating the pattern that has to be passed.
	 * @return String line input by the user
	 */
	private String inputScreenLine(String userIndication) {

		printToScreen("\n Please input in fashion: " + userIndication + "\n");		// Print the userIndication to screen
		String output = this.getMyScanner().nextLine();								// Extract the string	
		return output;																// Return the output
	}
	
	/**
	 * inputScreenPattern methods returns the String input from the screen by the user
	 * following a given pre-stablished pattern;
	 * @param pattern: Regular expression pattern to be matched
	 * @param userIndication: String indicating to the user the pattern to input
	 * @return String inputted by the user that succesfully matches the pattern
	 */
	public String inputScreenPattern(String pattern, String userIndication) throws IllegalArgumentException {
		// Determine if there is a match
		
		int counter = 0;		// Define a counter
		int maxCount = 10;		// Define the max count
		String myString = "";	// Initialize myString
		
		// Execute while loop to run 10 times the counter
		while (counter < maxCount) {
			
			// Collect the data from screen
			myString = inputScreenLine(userIndication);
			
			// Perform check on the pattern
			if (!myString.matches(pattern)) {
				
				counter += 1;								// Increment the counter accordingly
				printErrorMessage(maxCount - counter);   	// Print the warning to screen
				
			}
			else {
				break;
			}	
		}
		// Throw Exception when this occurs
		if (counter == maxCount) {
			throw new IllegalArgumentException(String.format("Improper user input, attempted %2d unsuccesfully.", maxCount));
		}
		
		
		return myString;
	}
	
	
	/**
	 * patternMatching static method determines if a given String input matches a pattern
	 * defined as a regular expression.
	 * @param pattern: String that constitutes the regular expression pattern.
	 * @param myString: String to be contrasted with the pattern
	 * @return boolean indicating if there is match (true) or not (false).
	 */
	public static boolean patternMatching(String pattern, String myString) {
		// patternMatching 
		boolean match = myString.matches(pattern);
		return match;
	}
	
	
	/**
	 * printErrorMessage prints a common message when an exception has been detected
	 * associated to an improper user input.
	 * @param nAttempsRemaining: integer indicating the number of attempts remaining the
	 * user has to input in a correct fashion.
	 */
	public void printErrorMessage(int nAttempsRemaining) {
		// Define the output String
		String outInCaseOfException = "\n ---> Invalid inputted values!!! Please input a proper item"
				+ " or introduce your choices in the explained fashion \n ---> ATTEMPTS REMAINING %2d \n";
		
		// Complete the String
		outInCaseOfException = String.format(outInCaseOfException, nAttempsRemaining);
		
		// Print to screen
		printToScreen(outInCaseOfException);	
		
	}
	
	// --------------------------- GETTERS AND SETTERS ------------------------//
	
	public Scanner getMyScanner() {
		return myScanner;
	}

	public void setMyScanner(Scanner myScanner) {
		this.myScanner = myScanner;
	}
};
