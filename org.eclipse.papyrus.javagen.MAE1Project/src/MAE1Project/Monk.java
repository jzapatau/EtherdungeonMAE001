// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 13/04/2019
 * 
 * Monk class constitutes the 6th of the concrete classes that
 * derived from Hero. The characteristics of a Monk are:
 * 1. Attack: High attack
 * 2. MaxHealthPoints: Low (however it can dodge attacks...when targeted it has
 * a 33% chance to dodge the attack, avoiding HP damage completely)
 * (When Beserkers kill a monster, they recover 5 Hps;
 */
public class Monk extends Hero {
	
	// -------------------------- METHODS --------------------------------/
	
	/**
	 * Class constructor 1
	 */
	public Monk(String name) {
		// Define the inputs for the superclass
		super("Monk", name, 50, 33);
		
		// Define the action and set it
		Action myAction = new Attack(this);
		
		// Set action
		this.setMyAction(myAction);
	}

	@Override
	public void performAction(Individual victim) {
		// Perform the action of the Monk
		
		// The Monk simply decreases the health of its victim by a parameter
		// given on the performance.
		
		// Re-adapt the health of the victim
		float victimLastHealth = victim.getLastHealth();
		
		// Compute new health
		victimLastHealth -= this.getPerformance();
		
		// Set the new health as the victims lastHealth
		victim.setLastHealth(victimLastHealth);
	}

	@Override
	public String returnClassName() {
		return "MONK";
	}

	@Override
	public boolean willDodgeAttack() {
		// Roll the dice to check if the attack will take place or not
		double randDouble = Math.random();
		boolean willDodge = randDouble <= 0.33; 
		return willDodge;
	}

	@Override
	public void retaliate(Individual offender) {
		// Do nothing
	}

}