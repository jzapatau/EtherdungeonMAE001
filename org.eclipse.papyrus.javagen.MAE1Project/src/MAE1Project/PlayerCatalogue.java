package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

// NO MODULES TO IMPORT 

/**
* @author Felix Zapata.
* Date: 3/04/2019
*/

/* PlayerCatalogue is an enum class which serves as a Catalogue
* to define the player mode.
*/
public enum PlayerCatalogue {
	
	// Define the elements in the Enum
	SINGLEPLAYER(1, 5),
	MULTIPLAYER(2, 1);
	
	/**
	 * numberOfPlayers indicates the amount of players allowed
	 * in each mode
	 */
	private final int numberOfPlayers;
	
	/**
	 * maxEncounters define the maximum number of encounters allowed
	 * to happen in each mode.
	 */
	private final int maxEncounters;
	
	/**
	 * PlayerCatalogue constructor
	 * @param number: integer indicating the number of players allowed in each mode
	 */
	private PlayerCatalogue(final int number, final int encounters) {
		numberOfPlayers = number;
		maxEncounters = encounters;
		}

	/**
	 * returnMode identifies the mode based on its numbering order.
	 * @param order: integer indicating the order of the PlayerMode.
	 * @return desired PlayerCatalogue object.
	 */
	public static PlayerCatalogue returnMode(int order) throws IndexOutOfBoundsException {
		// Convert to array
		PlayerCatalogue[] values = PlayerCatalogue.values();
		
		// Throw exception in case the index is out of bounds
		if (values.length - 1 < order) {
			throw new IndexOutOfBoundsException("Incorrect value for Player Selection");
		}
		
		// If no exception is thrown return the expected mode
		return values[order];
	}
	
	/**
	 * toString returns a String representation of the object
	 */
	public static String tostring(){
		// Assemble the string
		PlayerCatalogue[] values = PlayerCatalogue.values();
		
		// Initialize the string
		String out = "";
		
		// Loop through the values to obtain the string
		for (int i = 0; i < values.length; i++) {		
			out += values[i].toString() + ": " + Integer.toString(i) + " \t"; 
		}
		// Return the output
		return out;
	}
	


	// -------------------- GETTERS AND SETTERS ---------------------
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	
	public int getMaxEncounters() {
		return maxEncounters;
	}
	
}
