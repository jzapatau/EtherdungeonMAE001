package MAE1Project;

//------------------ IMPORT MODULES ---------------------------//

// No modules to import

// TODO: redefine methods of CharacterCatalogue to simplify populate
// of the users but also repopulation

/************************************************************/
/**
* @author Felix Zapata
* Date: 3/04/2019
* 
* CharacterCatalogue is an enum class which serves as a Catalogue
* to define the types of characters.
*/
public enum CharacterCatalogue {
	HERO,
	MONSTER;
	
	//------------------------- METHODS ------------------------------

	/**
	 * tostring method returns the String representation of the catalogue
	 * @return String representation of the catalogue.
	 */
	public static String tostring() {
		//Convert the object to string
		CharacterCatalogue[] values = CharacterCatalogue.values();
		String out = "";
		
		// Loop through the catalog
		for (int i = 0; i < values.length; i++) {
			out += String.format("%s: %d \t", values[i].toString(), i);
		}
		// Return the output
		return out;
	}
	
	/**
	 * generateUser creates the user with the team that has been picked
	 * @param settingObj: Settings object we want to modify
	 * @param userName: name of the user we want to generate
	 */
	public void generateUser(Settings settingObj, String userName) {
		// Decide which type of team to instantiate
		
		// Generate pattern and userIndication for inputScreen
		String pattern = String.format("^(\\d+,[^,]+,?){%d}$", settingObj.numberOfMembersinTeam);
		String userIndication = "%d Choices. Input number (%d - %d) followed by ',' and name. Example: 2,John Doe,3,Don Quixote,4,... ";
		
		switch (this) {
		
		// Case Hero
		case HERO:
			// Generate instance of team of Heroes
			Team<Hero> teamHero = new Team<Hero>();
			
			// Pick members of the team
			String outHero = "....Assemble your team: \n" + HeroCatalogue.tostring();
			settingObj.getUi().printToScreen(outHero);
			
			// Extract the members of the HeroCatalogue
			HeroCatalogue[] optionsHero = HeroCatalogue.values();
			
			// Get the data from the input
			userIndication = String.format(userIndication,
					settingObj.numberOfMembersinTeam, 1, optionsHero.length);								// Assemble userIndication
			String inValHero = settingObj.getUi().inputScreenPattern(pattern, userIndication);			    // Extract the values inputed in screen
			String[] selectedValuesStringHero = inValHero.split(",", 2*settingObj.numberOfMembersinTeam);	// Split the data
			
			// TODO: Implement IndexOutOfBounds exception
			
			int valueHero = -1;																			    // Initialize the variables
			String charNameHero = "";	
			
			// Loop through the inputs and generate the classes
			for (int i=0; i < selectedValuesStringHero.length-1; i+=2) {				
				// Parse the data
				valueHero = Integer.parseInt(selectedValuesStringHero[i]) - 1;
				charNameHero = selectedValuesStringHero[i+1];
				
				// Extract the Hero class and add it to the team
				Hero myHero = optionsHero[valueHero].instantiateIndividual(charNameHero);
				teamHero.add_member(myHero);
			}
			
			// Create the appropriate user instance
			User<Hero> newUserHero = new User<Hero>(userName, this, teamHero, false);
			
			// Set the team property of User
			settingObj.setUserHero(newUserHero);
			
			//Return
			return;
			
			// Case Monster
		case MONSTER:
			
			// Generate instance of team of Monsters
			Team<Monster> teamMonster = new Team<Monster>();
			
			// Pick members of the team
			String outMonster = "....Assemble your team: \n" + MonsterCatalogue.tostring();
			settingObj.getUi().printToScreen(outMonster);
			
			// Extract the members of the HeroCatalogue
			MonsterCatalogue[] optionsMonster = MonsterCatalogue.values();
			
			// Get the data from the input
			userIndication = String.format(userIndication,
					settingObj.numberOfMembersinTeam,
					1, optionsMonster.length);																	// Assemble userIndication
			String inValMonster = settingObj.getUi().inputScreenPattern(pattern, userIndication);			    // Extract the values inputed in screen
			String[] selectedValuesStringMonster = inValMonster.split(",", 2*settingObj.numberOfMembersinTeam);	// Split the data
			
			// TODO: Implement IndexOutOfBounds exception
						
			int valueMonster = -1;																				// Initialize the variables
			String charNameMonster = "";	
			
			// Loop through the inputs and generate the classes
			for (int i=0; i < selectedValuesStringMonster.length-1; i+=2) {				
				// Parse the data
				valueMonster = Integer.parseInt(selectedValuesStringMonster[i]) - 1;
				charNameMonster = selectedValuesStringMonster[i+1];
				
				// Extract the Hero class and add it to the team
				Monster myMonster = optionsMonster[valueMonster].instantiateIndividual(charNameMonster);
				teamMonster.add_member(myMonster);
			}
			
			// Create the appropriate user instance
			User<Monster> newUserMonster = new User<Monster>(userName, this, teamMonster, false);
			
			// Set the team property of User
			settingObj.setUserMonster(newUserMonster);
		
			// Return
			return;
		}
	}
	
	/**
	 * generateVirtualUser creates the virtual user
	 * @param settingObj: Settings object we want to modify
	 * @param userName: name of the user we want to generate
	 */
	public void generateVirtualUser(Settings settingObj, String userName) {
		// Decide which type of team to instantiate
		switch (this) {
		
		// Case Hero
		case HERO:
			// Generate instance of team of Heroes
			Team<Hero> teamHero = new Team<Hero>();
					
			// Extract the members of the HeroCatalogue
			HeroCatalogue[] optionsHero = HeroCatalogue.values();
			
			// Initialize the variable before entering the loop
			int randHero = -1;	
			String charNameHero = "";
			
			// Loop through the members of team
			for (int i=0; i < settingObj.numberOfMembersinTeam; i++) {
				
				// Throw the dice to pick the character and name it accordingly
				randHero = (int) (optionsHero.length*Math.random());
				charNameHero = String.format("Lionel Messi %d", i+1);
				
				// Generate the character and add it to the team
			    Hero myHero  = optionsHero[randHero].instantiateIndividual(charNameHero);
			    teamHero.add_member(myHero);
			}
			
			// Create the appropriate user instance
			User<Hero> newUserHero = new User<Hero>(userName, this, teamHero, true);		
			
			// Set the team property of User
			settingObj.setUserHero(newUserHero);
			
			// Return
			return;
			
			// Case Monster
		case MONSTER:
			
			// Generate instance of team of Heroes
			Team<Monster> teamMonster = new Team<Monster>();
					
			// Extract the members of the HeroCatalogue
			MonsterCatalogue[] optionsMonster = MonsterCatalogue.values();
			
			// Initialize the variable before entering the loop
			int randMonster = -1;	
			String charNameMonster = "";
			
			// Loop through the members of team
			for (int i=0; i < settingObj.numberOfMembersinTeam; i++) {
				
				// Throw the dice to pick the character and name it accordingly
				randMonster = (int) (optionsMonster.length*Math.random());
				charNameMonster = String.format("Sergio Ramos %d", i+1);
				
				// Generate the character and add it to the team
			    Monster myMonster  = optionsMonster[randMonster].instantiateIndividual(charNameMonster);
			    teamMonster.add_member(myMonster);
			}
			
			// Create the appropriate user instance
			User<Monster> newUserMonster = new User<Monster>(userName, this, teamMonster, true);		
			
			// Set the team property of User
			settingObj.setUserMonster(newUserMonster);
			
			// Return
			return;
		
		}
	}
	
}
