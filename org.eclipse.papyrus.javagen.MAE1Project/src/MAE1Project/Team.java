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

import java.util.ArrayList;			// Import Java ArrayList

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 3/04/2019
 * 
 * Team is a Java Generics class which can only accept as type
 * variable any child from Individual. Thus, it constitutes a 
 * Java Generics with bounded type variable. The idea behind this
 * class is to reduce the amount of code required.
 */
public class Team<T extends Individual> {
	
	//------------------- PROPERTIES ---------------------------//
	
	
	/**
	 * members property defines the members that belong to the
	 * team. It is implemented via a ArrayList.
	 */
	private ArrayList<T> members;
	
	/**
	 * activeMembers property defined the members that belong to the team
	 * that are actually active. That means that have not fainted.
	 */
	private ArrayList<T> activeMembers;
	
	/**
	 * participationQueue property defines a queue of the participation
	 * of each member in an encounter to assign priority to participation.
	 */
	private ArrayList<Boolean> participationQueue;
	
	//---------------------- METHODS ---------------------------//
	
	/**
	 * Class constructor, based on type inference feature included from
	 * Java 7.
	 */
	public Team() {
		// Instantiate the LinkedList
		this.members = new ArrayList<T>();
		this.activeMembers = new ArrayList<T>();
		this.participationQueue = new ArrayList<Boolean>();
	}
	/**
	 * Class constructor
	 * @param newMember: instance of type T, child of Individual which is
	 * to be added to the new Team instance.
	 */
	public Team(T newMember) {
		// Instantiate the LinkedList and add the member to the list
		this.members = new ArrayList<T>();
		this.participationQueue = new ArrayList<Boolean>();
		this.add_member(newMember);
	}
	
	/**
	 * Class constructor 
	 * @param newMembers: array if instances of type T of any length which will
	 * be part of the new Team instance.
	 */
	public Team(T[] newMembers) {
		// Instantiate the LinkedList
		this.members = new ArrayList<T>();
		this.participationQueue = new ArrayList<Boolean>();
		
		// Add the members to the team
		for (T elem :  newMembers) 
		{
			// Add member to the team
			this.add_member(elem);
		}
	}

	/**
	 * update() method removes those members of the team
	 * who are fainted/dead.
	 */
	public void update() {
		// Loop through the LinkedList and remove those members
		// who are fainted/dead
		for (T elem : this.members) 
		{
			// Call the update method of the element
			elem.update();
			
			// Ask if the element is fainted/dead
			if (elem.isFainted()) 
			{	
				// Remove the member from the activeMembers ArrayList;
				this.remove_member(elem);
			}
			
		}
		
		// Update the participation Queue
		this.updateParticipationQueue();
	}
	
	/**
	 * updateParticipationQueue updates the priorities associated to each of the members of the team
	 */
	private void updateParticipationQueue() {
		if (!participationQueue.contains(false)) {
			// Reset values in participationQueue
			participationQueue.replaceAll(value -> false);
		}
	}
	
	/**
	 * resetTeam updates the Team after an Encounter
	 */
	public void resetTeam() {
		// Reset active members and participationQueue
		activeMembers = new ArrayList<T>();
		participationQueue = new ArrayList<Boolean>();
		
		for (T elem : this.members) {
			// reset the element
			elem.reset();
			
			// Add the element to the activeMembers list and participation Queue
			activeMembers.add(elem);
			participationQueue.add(false);
		}
	}
	
	/**
	 * add_member adds a new member to the Team
	 * @param newMember: instance of type T to be added to the Team
	 */
	public void add_member(T newMember) {
		
		// Check the member is not in the LinkedList
		if (!this.members.contains(newMember)) 
		{
			// Add the newMember to the members list and active members list
			this.members.add(newMember);
			this.activeMembers.add(newMember);
			this.participationQueue.add(false);
		}
	}
	
	/**
	 * remove_member removes the specified member from the activeMembers list
	 * and the participation Queue
	 * @param member: instance of type T to be removed from the Team
	 */
	public void remove_member(T member) {
		
		// Check that the member is in the LinkedList
		if (this.activeMembers.contains(member))
		{
			// First remove from the participation queue
			this.participationQueue.remove(this.activeMembers.indexOf(member));
			
			// Remove the element from the list
			this.activeMembers.remove(member);
		}
	}

	/**
	 * toString method converts the Team instance into a representative
	 * string.
	 * @return: String representing the current state of the team
	 */
	public String toString() {
		// Initialize the string
		// TODO implement IndexOutOfBounds error Handling
		String out = String.format("Team: %s \n\n", this.members.get(0).returnClassTeam());
		
		// Team counter
		int counter = 0;
		
		// Run a loop through every member in the ArrayList of active and enabled members
		// to conform the list of available members in the team
		for (T elem : this.getActiveMembers())
		{
			// Update the counter
			counter += 1;
			// Append element string
			out += String.format("| %d ).  %s |\n", counter, elem);
		}
		
		// Return out string
		return out;
	}

	/**
	 * drafMember drafts an Active member of the team who has not participated
	 * @return T type member
	 */
	public T draftMember() {
		// Initialize the variable
		T out = null;
		
		// Check if there is a member that has not participated
		if (!(participationQueue.contains(false))) {
			this.updateParticipationQueue();
		}
		// Iterate until a false is find
		for (int idx = 0; idx < participationQueue.size(); idx++) {
			if (!participationQueue.get(idx)) {
				// Set proper participation value
				participationQueue.set(idx, true);
				out = activeMembers.get(idx);
				break;
			}
		}
	
		// Return out
		return out;
	}
	
	/**
	 * setClockOnTeamMembers sets the clock on every member present in the
	 * team.
	 * @param newClock: Clock instance we want to implement in every team 
	 * member.
	 */
	public void setClockOnTeamMembers(Clock newClock) {
		// Set the clock in all of the members of the team
		for (T elem : members) {
			elem.setClock(newClock);
		}
	}
	
	/**
	 * draftByInput drafts the owner of the Turn by means of user input
	 * @param ui: UI class instance
	 * @return owner of T type
	 */
	public T draftByInput(UI ui) {
		
		// Initialize the return value 
		T myCharacter = null;
		

		// Generate draft string
		String out = String.format("\n  Pick a Character: \n\n %s \n Choose a Character 1 - %d \n", 
				this.toString(), this.getActiveMembers().size());
		
		// Print to screen
		ui.printToScreen(out);
		
		// Generate pattern and user Indication
		String pattern = "^[";
		String userIndication = "Introduce either ";
		for (int i = 0; i < this.getActiveMembers().size(); i++) {
			pattern += Integer.toString(i+1);
			userIndication += Integer.toString(i+1) + ", ";
			}
		pattern += "]$";
		userIndication += "\n";
		
		String inputString = ui.inputScreenPattern(pattern, userIndication);
		int input = Integer.parseInt(inputString);
		
		// Set the owner
		// TODO: implement IndexOutOfBoundsException
		myCharacter = this.getActiveMembers().get(input-1);
		
		// Print the selection
		out = String.format("\n Selected %s \n", myCharacter.presentationCard());
		ui.printToScreen(out);
			
		// Return myOwner
		return myCharacter;
		
	}
	
	/**
	 * draftRandomly allows to draft an active member from the team in a random fashion
	 * @param ui: UI class instance
	 * @return randomly picked member of the team
	 */
	public T draftRandomly(UI ui) {
		// Initialize the output
		T mySelection = null;
		
		// Collect the attractiveness of the Active members, and generate a distribution array
		float sum = 0;
		
		// Generate a random number from 0 to 1 to obtain an owner
		float randInt = (float)  Math.random();
		
		// Get the total attractiveness
		for (T elem : this.getActiveMembers()) { sum += elem.getAttractiveness();}
		
		// Extract the member
		float binUp = 0;			// Initialize the binUp float
			
		for (T elem : this.getActiveMembers()) {
			binUp += elem.getAttractiveness() / sum;
			
			// Check if the random integer is below the binUp coefficient, if so conclude
			// the loop and set mySelection value
			if (randInt <= binUp) {
				mySelection = elem;
				break;
			}
		}
			
		// Print the selection
		String out = String.format("\n Selected %s \n", mySelection.presentationCard());
		ui.printToScreen(out);
		
		// Return the owner
		return mySelection;
	}
	
	
	/***************** GETTERS AND SETTERS ******************/
	
	public void setMembers(ArrayList<T> members) {
		this.members = members;
	}
	public ArrayList<T> getMembers() {
		return members;
	}
	public ArrayList<T> getActiveMembers() {
		return activeMembers;
	}
	public ArrayList<T> getActiveAndEnabledMembers(){
		
		// Generate a new ArrayList over which to iterate the elements
		ArrayList<T> myNewList = new ArrayList<T>();
		
		// Populate the ArrayList
		for (T elem : activeMembers) {
			// Select only those activeMembers that are enabled
			if (elem.getLastEnabled()) {
				myNewList.add(elem);
			}
		}
		
		// Return myNewList
		return myNewList;
	}
	public void setActiveMembers(ArrayList<T> activeMembers) {
		this.activeMembers = activeMembers;
	}
	public ArrayList<Boolean> getParticipationQueue() {
		return participationQueue;
	}
	public void setParticipationQueue(ArrayList<Boolean> participationQueue) {
		this.participationQueue = participationQueue;
	}
	
	
};
