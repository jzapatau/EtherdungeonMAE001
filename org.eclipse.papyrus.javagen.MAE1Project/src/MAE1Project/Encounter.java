// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

//No modules to import

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 3/04/2019
 * 
 * Class Encounter is in charge of commanding the dynamics of
 * any confrontation between two teams.
 * 
 */
public class Encounter {
	
	// ------------------ PROPERTIES ------------------------ //
	

	/**
	 * User is a User instance for the
	 * Heroes in the confrontation.
	 */
	private User<Hero> userHero;
	
	/**
	 * UserMonster is a USer instance for the
	 * Monster in the confrontation.
	 */
	private User<Monster> userMonster;

	/*
	 * ui is the UI instance required to perform the command.
	 */
	private UI ui;
	
	/**
	 * Clock clock instance helps to keep track of the different 
	 * turns that occur in the encounter
	 */
	private Clock clock;
	
	//----------------------- METHODS ---------------------------//

	/**
	 * Class constructor
	 * @param userHero: User of heroes
	 * @param userMonster: User of monsters
	 */
	public Encounter(User<Hero> userHero, User<Monster> userMonster) {
		// Set the properties of the object
		this.setUserHero(userHero);
		this.setUserMonster(userMonster);
		this.setUi(UI.INSTANCE);
		
		// Instantiate a new clock object and set it as the one of the users
		Clock myClock = new Clock();
		this.setClock(myClock);
	}
	
	/**
	 * runEncounter is the method which accounts for executing the
	 * encounter between the two parties.
	 */
	public void runEncounter() {
		// First Print to Screen the Encounter
		this.presentEncounter();
		
		// Set the clock counter to 0 as corresponds at the beginning of the
		// encounter
		this.resetClockOfEncounter();
			
		// Run the encounter
		while (!this.isFinished()) 
		{
			// If even run Turn for the Hero team
			if (clock.getTurnNum() % 2 == 0){
				// Create newTurn and run it
				Turn<Hero, Monster> newTurn = new Turn<Hero, Monster>(clock.getTurnNum(), userHero, userMonster);
				newTurn.runTurn();
			}
			else {
				// draft monster following participation Queue
				// Create newTurn and run it
				Turn<Monster, Hero> newTurn = new Turn<Monster, Hero>(clock.getTurnNum(), userMonster, userHero);
				newTurn.runTurn();
			}
			
			// Update the clock to move on to next turn
			updateClock();
			
			// Once the clock has been updated update the teams
			updateTeams();
			
		}
		
		// Close encounter on screen to move on
		closeEncounter();
	}
	
	/**
	 * presentEncounter() is a private method which handles the presentation
	 * of the objects at the beginning of the Encounter.
	 */
	private void presentEncounter() {
		// Collect both teams strings and merge them accordingly
		String out = "";
		out += "\n------------------------------- NEW FIGHT!!!!! GET READY!!!!!! --------------------------------------\n";
		out += "Featuring: \n";
		out += userHero.getTeam().toString();
		out += "\n\n VERSUS \n\n";
		out += userMonster.getTeam().toString();
		out += "\n--------------------------------- LET THE FIGHT TO DEATH BEGIN!!!! -----------------------------------\n";

		// Print the object to the screen
		this.getUi().printToScreen(out);
	}
	
	/**
	 * closeEncounter() is a private method which handles the presentation of the encounter
	 * of the objects at the ending of it. It presents the winner team.
	 */
	private void closeEncounter() {
		// Prepare the String
		String out = "";
		out += "\n --------------------------------------- FIGHT FINISHED!!!!! ---------------------------------------- \n";
		out += "Team winner: \n";
		
		// Check if encounter isWon
		if (!userHero.hasLost() & userMonster.hasLost()) {
			out += userHero.getTeam().toString();
		}
		if (!userMonster.hasLost() & userHero.hasLost()) {
			out += userMonster.getTeam().toString();
		}
		else {
			out += "We have a draw!";
		}
		// Print the string to the screen
		ui.printToScreen(out);
	}
	
	/**
	 * resetClock is a private method that sets the value of the clock that belongs to the encounter to
	 * 0. To be used only when the encounter starts.
	 */
	private void resetClockOfEncounter() {
		this.getClock().setTurnNum(0);
	}
	
	/**
	 * updateClock updates the clock by one turn at the end of the turn
	 */
	private void updateClock() {
		clock.update();
	}
	
	/**
	 * updateTeams updates the Teams involved at the end of the Encounter
	 */
	private void updateTeams() {
		// Update the teams of userHero and userMonster
		userHero.getTeam().update();
		userMonster.getTeam().update();
	}

	/***************** GETTERS AND SETTERS ******************/

	/**
	 * isWon helps determine if the encounter was won
	 * @return boolean indicating if the encounter was won.
	 */
	public boolean isWon() {
		// Construct the boolean to determine if an encounter was won
		return userHero.remainsPlayer() || userMonster.remainsPlayer();
	}
	
	public boolean isFinished() {
		return (userHero.hasLost() || userMonster.hasLost());
	}

	public User<Hero> getUserHero() {
		return userHero;
	}

	public void setUserHero(User<Hero> userHero) {
		this.userHero = userHero;
	}

	public User<Monster> getUserMonster() {
		return userMonster;
	}

	public void setUserMonster(User<Monster> userMonster) {
		this.userMonster = userMonster;
	}

	public UI getUi() {
		return ui;
	}

	public void setUi(UI ui) {
		this.ui = ui;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		
		// Set the clock on both teams that will be part of the encounter
		userHero.getTeam().setClockOnTeamMembers(clock);
		userMonster.getTeam().setClockOnTeamMembers(clock);
		
		// Set the clock on the encounter
		this.clock = clock;
	}
	
	
};
