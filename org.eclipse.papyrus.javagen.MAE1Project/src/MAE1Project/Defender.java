// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 14/04/2019
 * 
 * Defender class constitutes the 9th of the concrete classes that
 * derive from Hero. The characteristics of Defender are:
 * 1. Attack: Below average - , retaliate when hit,
 *  increased chance of being targeted (when selecting who to attack,
 *  the monsters are more likely to target the Defender. 
 *  When Defenders are hit, they hit back the monster that attacked them.)
 * 2. MaxHealthPoints: above average
 * 3. Attractiveness: 2 (coefficient multiplier for random draft)
 */
public class Defender extends Hero {
	
	// -------------------------- METHODS --------------------------------/
	
	/**
	 * Class constructor 1
	 */
	public Defender(String name) {
		// Define the inputs for the superclass (Defender has twice the attractiveness of
		// getting hit by a Monster)
		super("Defender", name, 50, 67, 2);
		
		// Define the action and set it
		Action myAction = new Attack(this);
		
		// Set action
		this.setMyAction(myAction);
	}

	@Override
	public void performAction(Individual victim) {
		// Perform the action of the Defender
		
		// The Defender simply decreases the health of its victim by a parameter
		// given on the performance.
		
		// Re-adapt the health of the victim
		float victimLastHealth = victim.getLastHealth();
		
		// Compute new health
		victimLastHealth -= this.getPerformance();
		
		// Set the new health as the victims lastHealth
		victim.setLastHealth(victimLastHealth);
		
	}

	@Override
	public void retaliate(Individual offender) {
		// The defender is the only type of Hero which
		// does retaliates. For such reason execute the action
		// of the Defender to the offender.
		this.getMyAction().execute(offender);
		
	}

	@Override
	public boolean willDodgeAttack() {
		return false;
	}

	@Override
	public String returnClassName() {
		return "DEFENDER";
	}


}