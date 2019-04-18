package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
* @author Felix Zapata
* Date: 3/04/2019
* 
* HeroCatalogue is an enum class which serves as a Catalogue
* to define the heroes.
*/
public enum HeroCatalogue{

	// Define the Hero classes available
	WARRIOR,
	PALADIN,
	CLERIC,
	ASSASIN,
	ROGUE,
	BESERKER,
	MONK,
	DUELIST,
	DEFENDER;

	public static String tostring() {
		// Convert to string
		HeroCatalogue[] vals = HeroCatalogue.values();
		String out = "Heroes Catalogue: \t\n";
		for (int i = 0; i < vals.length; i++) {
			out += String.format("| %2d) %10s | \n", i+1, vals[i]);
		}
		// Return
		return out;
	}
	
	/**
	 * instantiateIndividual calls the specific constructor by choosing the
	 * right enum
	 * @param name: String with the name of the Hero
	 * @return Hero class instance
	 */
	public Hero instantiateIndividual(String name) {
		// Implement a switch case that returns the individual object
		switch (this) {
		case WARRIOR: return new Warrior(name);
		case PALADIN: return new Paladin(name);
		case CLERIC: return new Cleric(name);
		case ASSASIN: return new Assasin(name);
		case ROGUE: return new Rogue(name);
		case BESERKER: return new Beserker(name);
		case MONK: return new Monk(name);
		case DUELIST: return new Duelist(name);
		case DEFENDER: return new Defender(name);
		default: return new Paladin(name);
		}
	}
	
}