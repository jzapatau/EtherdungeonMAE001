// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

import java.util.ArrayList;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 14/04/2019
 */
 
/* Mummy class constitutes the second of the concrete classes that
 * derive from Monster. The characteristics of a Mummy are:
 * 1. Attack: High (only attacks every two turns)
 * 2. MaxHealthPoints: Medium
 * 
 */
public class Mummy extends Monster {

	// -------------------------- METHODS --------------------------------/
	
	/**
	 * Class constructor 1
	 */
	public Mummy(String name) {
		// Define the inputs for the superclass
		super("Mummy", name, 40, 70);
		
		// Define the action and set it
		Action myAction = new Attack(this);
		
		// Set action
		this.setMyAction(myAction);
	}

	@Override
	public void performAction(Individual victim) {
		// Mummy performs a regular attack on its victim of type
		// Hero with the difference that it is disabled to attack in the following turn
		// but in the next it'll be ok to attack.
		
		// The Mummy simply decreases the health of its victim by a parameter
		// given on the performance.
		
		// Re-adapt the health of the victim
		float victimLastHealth = victim.getLastHealth();
		
		// Compute new health
		victimLastHealth -= this.getPerformance();
		
		// Set the new health as the victims lastHealth
		victim.setLastHealth(victimLastHealth);
		
		// Now disable the object for the next turn
		int nextTurnNum = this.getClock().getTurnNum() + 2;
		
		// Get the isEnabled ArrayList of the object and update it
		ArrayList<Boolean> isEnabled = this.getIsEnabled();
		
		// Assign the new isEnabled
		if (nextTurnNum < isEnabled.size()) {
			// Set false to the value assigned to the next Turn
			isEnabled.set(nextTurnNum - 1, false);
			isEnabled.set(nextTurnNum, false);
		}
		else {
			// Add a new record for the next turn which says isEnabled is false;
			isEnabled.add(false);
			isEnabled.add(false);
		}
			
	}

	@Override
	public void retaliate(Individual offender) {
		// Do nothing
	}
};
