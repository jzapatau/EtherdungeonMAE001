// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
 * @author Felix Zapata.
 * Date: 3/04/2019
 */
 
/* Class Turn is in charge of commanding the dynamics of
 * a Turn assigned to any of the two teams. It is a Java Generics
 * class which has as type variable any descendant of Individual
 */
public class Turn<T extends Individual, Q extends Individual> {
	
	// ------------------ PROPERTIES ------------------------ //
	
	/**
	 * int turnID gives the identifier to the Turn in order to know its
	 * time coordinate within the Encounter.
	 */
	private int turnID;
	/**
	 * UserA property stores the User from which the owner shall be picked
	 */
	private User<T> UserA;
	
	/**
	 * UserB property stores the opposing team
	 */
	private User<Q> UserB;
	
	/**
	 * owner is the member of UserA team who owns the encounter
	 */
	private T owner;
	
	/**
	 * ui property stores the UI singleton
	 */
	private UI ui;
	
	//----------------------- METHODS ---------------------------//
	
	/**
	 * Class constructor
	 * @param ID: Integer that identifies the Turn
	 * @param UserA: User of type T which extends individual
	 * @param UserB: User of type Q which extends individual
	 */
	public Turn(int ID, User<T> UserA, User<Q> UserB){
		// Set properties
		this.setTurnID(ID);
		this.setUserA(UserA);
		this.setUserB(UserB);
		this.setUi(UI.INSTANCE);
		
		// Present the turn before doing the draft
		presentTurn();
		
		// Perform the owner draft
		T myDraft = UserA.draftTeamMember();
		
		// Set the owner of the Turn
		this.setOwner(myDraft);
		
	}
	
	/**
	 * Class constructor 2
	 * @param owner: represents the entity (Individual) who owns the turn and who is
	 * going to perform its action over a team-mate or an opponent
	 * @param UserA : User instance associated to the owner. Has to be of same type
	 * of the owner
	 * @param UserB: User instance associated to the opponents. 
	 */
	public Turn(T owner, User<T> UserA, User<Q> UserB) {
		// Set properties
		this.setOwner(owner);
		this.setUserA(UserA);
		this.setUserB(UserB);
		this.setUi(UI.INSTANCE);
	}
	
	/**
	 * runTurn method executes the specified turn over the owner
	 */
	public void runTurn() {
		// Perform check on owner, if different run performAction 
		if (owner != null) {
			owner.performAction(UserA, UserB);
		}
	}
	
	/**
	 * presentTurn presents the new turn to the user to know it's location
	 * within the game
	 */
	private void presentTurn() {
		// Generate the string to present
		String out = "\n------------------------ STARTING TURN: %8d, Owner: %10s ------------------------------------\n";
		out = String.format(out, this.getTurnID(), UserA.getName());
		ui.printToScreen(out);
	}
	
	/***************** GETTERS AND SETTERS ******************/
	
	public User<T> getUserA() {
		return UserA;
	}

	public void setUserA(User<T> UserA) {
		this.UserA = UserA;
	}

	public User<Q> getUserB() {
		return UserB;
	}

	public void setUserB(User<Q> UserB) {
		this.UserB = UserB;
	}

	public T getOwner() {
		return owner;
	}

	public void setOwner(T owner) {
		this.owner = owner;
	}

	public UI getUi() {
		return ui;
	}

	public void setUi(UI ui) {
		this.ui = ui;
	}

	public int getTurnID() {
		return turnID;
	}

	public void setTurnID(int turnID) {
		this.turnID = turnID;
	}
	
};
