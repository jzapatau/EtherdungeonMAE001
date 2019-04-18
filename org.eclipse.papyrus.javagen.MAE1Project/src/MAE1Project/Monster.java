// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 13/04/2019
 * 
 * Monster abstract class inherits from the Individual abstract
 * class. 
 */
public abstract class Monster extends Individual {

	
	//----------------------- METHODS ---------------------------//
	
	/**
	 * Class constructor 1
	 * @param type: String defining the type of Monster
	 * @param name: String defining the name of the Monster
	 * @param action: Action instance related to the Monster
	 * @param performance: float indicating the relative performance of the Monster
	 * @param healthPoints: maximum health points allowed to the class to have
	 */
	public Monster(String type, String name, Action action, float performance, float healthPoints){
		super(type, name, action, performance, healthPoints);   	// Call superclass constructor
	}
	
	/**
	 * Class constructor 2
	 * @param type: String defining the type of Monster
	 * @param name: String defining the name of the Monster
	 * @param performance: float indicating the relative performance of the Monster
	 * @param healthPoints: maximum health points allowed to the class to have
	 */
	public Monster(String type, String name, float performance, float healthPoints) {
		super(type, name, performance, healthPoints);				// Call superclass constructor
	}
	
	/**
	 * Class constructor 3
	 * @param type: String defining the type of Monster
	 * @param name: String defining the name of the Monster
	 * @param performance: float indicating the relative performance of the Monster
	 * @param healthPoints: maximum health points allowed to the class to have
	 * @param attractiveness: float indicating how attractive is the Monster
	 */
	public Monster(String type, String name, float performance, float healthPoints,
			float attractiveness) {
		super(type, name, performance, healthPoints, attractiveness);	// Call superclass constructor
	}
	
	/**
	 * returnClassTeam is an inherited method that returns a String
	 * which defines the Team to which the Individual belongs to.
	 * @return String to which the Individual belongs to
	 */
	public String returnClassTeam() {
		// Return the string
		return "MONSTER";
	};
};
