// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

/**
 * Team.java implements the Team Java Generics class.
 * @author Felix Zapata
 * Date: 21/03/2019
 * ISAE - SUPAERO MAE1
 */

package MAE1Project;


//------------------ IMPORT MODULES ---------------------------//

import java.util.ArrayList;
import java.lang.Boolean;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 3/04/2019
 * 
 * Class Individual is the parent class of all the characters present in the
 * game. It is an abstract class and describes the basic behavior of all those
 * who derive from it.
 */

public abstract class Individual{
	
	// ------------------ PROPERTIES ------------------------ //
	
	/**
	 * set the maximum health points achievable by the invidivual
	 */
	private float maxHealth;
	/**
	 * String Name property corresponds to the name of the individual in the actual course of the game.
	 */
	private String name;
	/**
	 * ArrayList Health represents the status of the individual. If 0 the individual is dead
	 */
	private ArrayList<Float> health;
	
	/**
	 * ArrayList isEnabled represents the status of the individual in terms of if it is enabled to act or not
	 */
	private ArrayList<Boolean> isEnabled;
	
	/**
	 * float performance indicate the performance of the individual on the action it is meant to perform.
	  * 
	 */
	private float performance;

	/**
	 * boolean isFainted indicates if the Individual is fainted or not based on his current health
	 */
	private boolean isFainted = false;
	/**
	 * UI instance used to command the execution on screen of the program.
	 */
	protected UI ui;
	/**
	 * String type used to identify the class type
	 */
	private String type = null;
	/**
	 * Action myAction instance that defines the Individual object
	 */
	private Action myAction;
	
	/**
	 * Clock myClock is a Clock instance which helps the individual know of the current
	 * state of the encounter
	 */
	private Clock clock;
	
	/**
	 * Float attractiveness is a coefficient that determines the attractiveness of
	 * an Individual to become a target of a particular action. The default value of
	 * attractiveness is 1.
	 */
	private float attractiveness = 1;
	
	//----------------------- METHODS ---------------------------//
	
	/**
	 * Class constructor 1
	 * @param type: String defining the type of the Individual
	 * @param name: String defining the name of the Individual
	 * @param action: Action instance related to the Individual
	 * @param performance: float indicating the relative performance of the Individual related to its action
	 * @param healthPoints: float indicating the healthPoints of the individual at initialization.
	 */
	public Individual(String type, String name, Action action,float performance, float healthPoints) {
		// Set the properties at the constructor
		this.setType(type);
		this.setName(name);
		this.setMyAction(action);
		this.setPerformance(performance);
		this.maxHealth = healthPoints;
		this.setUi(UI.INSTANCE);
		this.clock = new Clock();
		
		// Set the health property to the right object
		ArrayList<Float> myHealth = new ArrayList<Float>();
		myHealth.add(healthPoints);
		this.setHealth(myHealth);
		
		// Set the enabled property
		ArrayList<Boolean> myEnabled = new ArrayList<Boolean>();
		myEnabled.add(true);
		this.setIsEnabled(myEnabled);
		
		}

	/**
	 * Class constructor 2
	 * @param type: String defining the type of the Individual
	 * @param name: String defining the name of the Individual
	 * @param performance: float indicating the relative performance of the Individual related to its action
	 * @param healthPoints: float indicating the healthPoints of the individual at initialization.
	 */
	public Individual(String type, String name, float performance, float healthPoints) {
		// Set the properties of the constructor
		this.setType(type);
		this.setName(name);
		this.setPerformance(performance);
		this.maxHealth = healthPoints;
		this.setUi(UI.INSTANCE);
		this.clock = new Clock();
		
		
		// Set the health property to the right object
		ArrayList<Float> myHealth = new ArrayList<Float>();
		myHealth.add(healthPoints);
		this.setHealth(myHealth);
		
		// Set the enabled property
		ArrayList<Boolean> myEnabled = new ArrayList<Boolean>();
		myEnabled.add(true);
		this.setIsEnabled(myEnabled);
	}

	/**
	 * Class constructor 3
	 * @param type: String defining the type of the Individual
	 * @param name: String defining the name of the Individual
	 * @param performance: float indicating the relative performance of the Individual related to its action
	 * @param healthPoints: float indicating the healthPoints of the individual at initialization
	 * @param attractiveness: float indicating how attractive is the individual in terms of performing
	 * an action.
	 */
	public Individual(String type, String name, float performance, float healthPoints, float attractiveness) {
		// Set the properties of the constructor
		this.setType(type);
		this.setName(name);
		this.setPerformance(performance);
		this.maxHealth = healthPoints;
		this.setUi(UI.INSTANCE);
		this.clock = new Clock();
		
		
		// Set the health property to the right object
		ArrayList<Float> myHealth = new ArrayList<Float>();
		myHealth.add(healthPoints);
		this.setHealth(myHealth);
		
		// Set the enabled property
		ArrayList<Boolean> myEnabled = new ArrayList<Boolean>();
		myEnabled.add(true);
		this.setIsEnabled(myEnabled);
		
		// Set the attractiveness of the object
		this.setAttractiveness(attractiveness);
	}

	/**
	 * performAction implementation over a single victim
	 * @param victim: Individual instance over which we want to
	 * perform the action.
	 */
	public abstract void performAction(Individual victim);

	/**
	 * retaliate automatically performs the action on the offender
	 * object.
	 * @param offender: Individual instance over which the object
	 * desires to retaliate
	 */
	public abstract void retaliate(Individual offender);
	/**
	 * performAction method implementation discriminates between friend
	 * or foe in order to performAction over a group of objects
	 * @param ownerUser: User instance who owns the individual team
	 * @param opponentUser: User instance who owns the opposing team
	 */
	
	public <T extends Individual, Q extends Individual> void performAction(User<T> ownerUser, User<Q> opponentUser) {
		//  performAction in class Warrior will simply do a regular attack over an opponent,
		// so the targetTeam in this particular case will be victims of type monster
	
		// Initialize myVictim
		Q myVictim = null;
		
		// Print the message of draft with Action name
		String out = String.format("Who will be %s ?", this.getMyAction().getName());
		ui.printToScreen(out);
		
		// Draft the victim based on the userInput boolean
		if (!(ownerUser.isVirtual())) {
			// If userInput boolean is True then proceed to draft, otherwise
			myVictim = opponentUser.getTeam().draftByInput(ui);
		}
		else {
			// Perform a random draft on the victim
			myVictim = opponentUser.getTeam().draftRandomly(ui);
		}
		
		// Execute the action over the victim
		this.getMyAction().execute(myVictim);
	
	}

	/**
	 * toString method converts the Individual instance into a string
	 * representation which can be later printed to screen.
	 * @return String output which represents the Individual instance
	 * state.
	 */
	public String toString() {
		// Define a format for printing the object.
		// The information contained in the print out is:
		// Name, Type, health
		
		// Define the format
		String format = "%15s of type: %8s from team: %8s, health: %8.1f / %-5.1f HPs, performance: %8.1f, Enabled: %8s";

		// Create the output
		String output = String.format(format, this.getName(), 
									  this.returnClassName(),
									  this.returnClassTeam(),
									  this.getLastHealth(),
									  this.maxHealth,
									  this.getPerformance(),
									  Boolean.toString(this.getLastEnabled()));
		
		// Return the output
		return output;
	}
	
	/**
	 * presentationCard provides a String with a short description of the Individual
	 * instance.
	 * @return String containinf Name and Type of the Individual
	 */
	public String presentationCard() {
		// Define a format for doing a presentationCard of the Individual
		// The information contained in the presentation card is:
		// Name, Type
		
		// Define the format
		String format = "%s the %s";
	
		// Create the output
		String output = String.format(format, this.getName(), this.returnClassName());
		
		// Return the output
		return output;
	}

	/**
	 * prettyPrint method prints the Individual instance to a representative
	 * string which describes the current state of the object.
	 */
	public void prettyPrint() {
		// Get the object's string representation by means of toString()
		// method.
		String output = this.toString();
		
		// Print the object to screen
		this.ui.printToScreen(output);
	}
	
	/*
	 * printFainted method prints to screen when an individual has fainted.
	 */
	private void printFainted() {
		// Get the string of the object and add to it 
		String out = "-----> \t" + presentationCard() + " has fainted \n";
		this.ui.printToScreen(out);
	}
	
	public void update() {
		// Update method performs the update on the object to have consistent dimension
		// with the clock
		
		// Update the health and isEnabled ArrayLists of the Individual
		this.updateHealth();
		this.updateIsEnabled();
	}
	
	/**
	 * reset basically returns the individual to the corresponding state before
	 * an encounter
	 */
	public void reset() {
		
		// Get the last value of health
		float lastHealth = this.getLastHealth();
		
		if (isFainted) {

			// If the Individual isFainted returns true, then reset its health
			// to 25% of its maxHealth value
			ArrayList<Float> newHealth = new ArrayList<Float>();
			newHealth.add((float) 0.25 * maxHealth);
			health = newHealth;

		}
		else
		{
			// If the individual has not fainted then re instantiate health and isEnabled
			// to account for the last value recorded from the previous encounter
			ArrayList<Float> newHealth = new ArrayList<Float>();
			ArrayList<Boolean> newisEnabled = new ArrayList<Boolean>();
			newHealth.add(lastHealth);
			newisEnabled.add(true);
		}
	}
	
	/**
	 * willDodgeAttack determine is the object itself will dodge an incoming attack
	 * or not
	 * @return
	 */
	public abstract boolean willDodgeAttack();

	/**
	 * returnClassName method is an abstract method that returns a String
	 * containing the class name
	 * @return className: String containing the class name
	 */
	public abstract String returnClassName();
	
	/**
	 * returnClassTeam is an abstract method that returns a String
	 * which defines the Team to which the Individual belongs to.
	 * @return String to which the Individual belongs to
	 */
	public abstract String returnClassTeam();
	
	/***************** GETTERS AND SETTERS ******************/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLastHealth() {
		return health.get(clock.getTurnNum());
	}
	
	public boolean getLastEnabled() {
		return isEnabled.get(clock.getTurnNum());
	}
	
	public ArrayList<Float> getHealth(){
		return health;
	}
	
	public void setHealth(ArrayList<Float> health) {
		this.health = health;
	}
	
	public void setLastHealth(float healthVal) {
		// Check we don't surpass the maximum health
		if (maxHealth < healthVal) {	
			healthVal = maxHealth;
		}
		
		// TODO: implement IndexOutOfBoundsException to account when this
		// command is not properly implemented
		// Set the last value available
		health.set(clock.getTurnNum(), healthVal);
		
	}

	/**
	 * updateHealth only to be used when updating the object. This is important since it is
	 * only to be called when a turn ends and the turnNum in clock is updated
	 */
	private void updateHealth() {
		
		// Extract the last health value present in the object
		// TODO: implement IndexOutOfBoundsException accordingly to avoid conflicts
		float lastHealth = health.get(clock.getTurnNum() - 1);
		
		// Initialize newLastHealth 
		float newLastHealth = 0; 

		// If the size of health contains the updated turn it means that those values
		// have already been initialized and thus we have to account for them
		if (clock.getTurnNum() < health.size()) {
			newLastHealth = this.getLastHealth() + lastHealth;
			health.set(clock.getTurnNum(), newLastHealth);
		}
		else {
			
			// Take the last value and append it to the health ArrayList
			newLastHealth = lastHealth;
			health.add(newLastHealth);
		}
			
		// Update isFainted accordingly (important to know if residual attacks "faint" the individual)
		if (newLastHealth <= 0) 
		{	
			this.setFainted(true);
		}
	}
	
	/**
	 * updateIsEnabled performs the update of the IsEnabled property at the end of a turn
	 * The default value of isEnabled is true unless it says otherwise.
	 */
	private void updateIsEnabled() {
		
		// Check the isEnabled property size, if it's lower than the clock updated turn
		// then update.
		// TODO: Check the flow of the algorithm at this point. Possible IndexOutOfBoundsException
		// because of mismatch between the clock and the size of the array. Same phenomenon
		// expected for health ArrayList.
		if (isEnabled.size() == clock.getTurnNum()) {
			isEnabled.add(true);
		}	
	}
	
	
	public float getPerformance() {
		return performance;
	}

	public void setPerformance(float performance) {
		this.performance = performance;
	}

	public boolean isFainted() {
		return isFainted;
	}

	public void setFainted(boolean isFainted) {		
		// Print to screen the individual has died
		if (this.isFainted() == false && isFainted == true) 
		{
			this.printFainted();
		}
		this.isFainted = isFainted;
	}

	public UI getUi() {
		return ui;
	}

	public void setUi(UI ui) {
		this.ui = ui;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		// Check the property has been initialized, otherwise do nothing
		if (this.getType() == null) 
		{
			this.type = type;
		}
	}

	public Action getMyAction() {
		return myAction;
	}

	public void setMyAction(Action myAction) {
		this.myAction = myAction;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public ArrayList<Boolean> getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(ArrayList<Boolean> isEnabled) {
		this.isEnabled = isEnabled;
	}

	public float getAttractiveness() {
		return attractiveness;
	}

	public void setAttractiveness(float attractiveness) {
		this.attractiveness = attractiveness;
	}
	
	
	
};
