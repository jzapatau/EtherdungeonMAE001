package MAE1Project;

/************************************************************/
/**
 * @author Felix Zapata
 * Date: 3/04/2019
 * 
 * Class clock helps keep track of an encounter by counting the number of turns
 */
public class Clock {
	
	// --------------------------- PROPERTIES --------------------------
	
	/*
	 * turnNum is an integer which indicates the turn number in which the
	 * encounter is located.
	 * turnNum updates every time a turn is FINISHED!!!!
	 */
	private int turnNum = 0;
	
	// ---------------------------- METHODS -----------------------------
	
	/**
	 * update method adds 1 to the value of the turnNum of the clock
	 */
	public void update() {
		turnNum += 1;
	}

	// ---------------------- GETTERS AND SETTERS -----------------------
	
	public int getTurnNum() {
		return turnNum;
	}

	public void setTurnNum(int turnNum) {
		this.turnNum = turnNum;
	}
	
	
}
