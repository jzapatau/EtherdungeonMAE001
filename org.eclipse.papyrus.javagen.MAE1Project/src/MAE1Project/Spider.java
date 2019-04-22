// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

import java.util.ArrayList;

/************************************************************/
/**
 * @author Felix Zapata.
 * Date: 14/04/2019
 */
 
/* Spider class constitutes the first of the concrete classes that
 * derive from Monster. The characteristics of a Spider are:
 * 1. Attack: Low (can poison its target (same effect as for the Rogue))
 * 2. MaxHealthPoints: Low
 * 
 */
public class Spider extends Monster {

	// -------------------------- METHODS --------------------------------/
	
	/**
	 * Class constructor 1
	 */
	public Spider(String name) {
		// Define the inputs for the superclass
		super("Spider", name, 10, 40);
		
		// Define the action and set it
		Action myAction = new Attack(this);
		
		// Set action
		this.setMyAction(myAction);
	}

	@Override
	public void performAction(Individual victim) {
		// The Spider acts in same fashion as Rogue by
		// poisoning its target over the span of 3 turns by decreasing
		// the HPs by 3 on every turn.
		
		// First perform the main attack
		// Re-adapt the health of the victim
		float victimLastHealth = victim.getLastHealth();
		
		// Compute new health
		victimLastHealth -= this.getPerformance();
		
		// Set the new health as the victims lastHealth
		victim.setLastHealth(victimLastHealth);
		
		// Poison then the victim to have a non-immediate effect.
		// First get the health ArrayList of the victim
		ArrayList<Float> victimHealth = victim.getHealth();
		
		// Append to it 3 more records with -3 (for the 3 next turns when the health ArrayList is
		// update
		victimHealth.add((float) -3);
		victimHealth.add((float) -3);
		victimHealth.add((float) -3);	
	}

	@Override
	public void retaliate(Individual offender) {
		// Do nothing
	}
	
	
}