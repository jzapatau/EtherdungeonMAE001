// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 13/04/2019
 * 
 * Cleric class constitutes the third of the concrete classes that
 * derive from Hero. The characteristics of a Cleric are:
 * 1. Attack: does not attack but instead heals its allies (target an ally
 * and give them back HealthPoints)
 * 2. MaxHealthPoints: Low
 * 
 */
public class Cleric extends Hero {
	
	// -------------------------- METHODS --------------------------------/
	
	/**
	 * Class constructor 1
	 */
	public Cleric(String name) {
		// Define the inputs for the superclass
		super("Cleric", name, 20, 40);
		
		// Define the action and set it
		Action myAction = new Heal(this);
		
		// Set action
		this.setMyAction(myAction);
	}
	
	@Override
	public void performAction(Individual victim) {
		// Perform the action of the Cleric
		
		// The Cleric simply increases the health of its victim by a parameter
		// given on the performance.
		
		// Re-adapt the health of the victim
		float victimLastHealth = victim.getLastHealth();
		
		// Compute new health (increase it)
		victimLastHealth += this.getPerformance();
		
		// Set the new health as the victims lastHealth
		victim.setLastHealth(victimLastHealth);
		
		
	}

	@Override
	public <T extends Individual, Q extends Individual> void performAction(User<T> ownerUser, User<Q> opponentUser) {
		//  performAction in class Cleric will simply do a regular heal over a friend,
		// so the targetTeam in this particular case will be mates of type Hero
		
		// Initialize myMate
		T myMate = null;
		
		// Print the message of draft with Action name
		String out = String.format("Who will be %s ?", this.getMyAction().getName());
		ui.printToScreen(out);
		
		// Draft the mate based on the userInput boolean
		if (!(ownerUser.isVirtual())) {
			// If userInput boolean is True then proceed to draft, otherwise
			myMate = ownerUser.getTeam().draftByInput(ui);
		}
		else {
			// Perform a random draft on the mate with Uniform Probability
			myMate = ownerUser.getTeam().draftRandomlyUniformProbability(ui);
		}
		
		// Execute the action over the mate
		this.getMyAction().execute(myMate);
		
		
	}

	@Override
	public String returnClassName() {
		return "CLERIC";
	}

	@Override
	public boolean willDodgeAttack() {
		return false;
	}

	@Override
	public void retaliate(Individual offender) {
		// Do nothing	
	}
};
