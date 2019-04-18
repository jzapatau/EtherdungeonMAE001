package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
* @author Felix Zapata
* Date: 3/04/2019
* 
* MonsterCatalogue is an enum class which serves as a Catalogue
* to define the monster.
*/
public enum MonsterCatalogue{

	// Define the Monster classes available
	// TODO: define complete collection of MonsterCatalogue

	MUMMY,
	SPIDER,
	SLIME;
	
	public static String tostring() {
		// Convert to string
		MonsterCatalogue[] vals = MonsterCatalogue.values();
		String out = "Monster Catalogue: \t\n";
		for (int i = 0; i < vals.length; i++) {
			out += String.format("| %2d) %10s | \n", i+1, vals[i]);
		}
		// Return
		return out;
	}
	
	/**
	 * instantiateIndividual calls the specific constructor by choosing the
	 * right enum
	 * @param name: String with the name of the Monster
	 * @return Monster class instance
	 */
	public Monster instantiateIndividual(String name) {
		// Implement a switch case that returns the individual object
		// TODO: Implement constructors of each of these classes
		switch (this) {
		case MUMMY: return new Mummy(name);
		case SPIDER: return new Spider(name);
		case SLIME: return new Slime(name);
		default: return new Mummy(name);
		}
	}
	
}
