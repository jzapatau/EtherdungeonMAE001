package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
* @author Felix Zapata.
* Date: 3/04/2019
*/

/* MonsterCatalogue is an enum class which serves as a Catalogue
* to define the monster.
*/
public enum MonsterCatalogue implements Catalog{

	// Define the Monster classes available
	MUMMY,
	SPIDER,
	SLIME,
	DONALDTRUMP,
	GILETJAUNE,
	JOKER;
	
	public static String tostring() {
		// Convert to string
		MonsterCatalogue[] vals = MonsterCatalogue.values();
		String out = "Monster Catalogue: \t\n";
		for (int i = 0; i < vals.length; i++) {
			out += String.format("| %2d) %12s | \n", i+1, vals[i]);
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
	@SuppressWarnings("unchecked")
	public Monster instantiateIndividual(String name) {
		// Implement a switch case that returns the individual object
		switch (this) {
		case MUMMY: return new Mummy(name);
		case SPIDER: return new Spider(name);
		case SLIME: return new Slime(name);
		case DONALDTRUMP: return new DonaldTrump(name);
		case GILETJAUNE: return new GiletJaune(name);
		case JOKER: return new Joker(name);
		default: return new Mummy(name);
		}
	}
	
}
