/**
 * NOTE: The TableView JavaFx elements automatically allow for sortation of
 * desired column (e.g. sort by id by clicking the arrow on the column header in
 * the UI).
 * 
 * Return types must be String in order for the columns to update correctly, if
 * processing is needed it must be done in the moment by parsing then returned
 * back to a string value (I could be wrong though :) ).
 *
 */
public class PlayerTable {

	String playerID, firstName, lastName, position, jersey, TeamID;

	public PlayerTable(String playerID, String firstName, String lastName, String position, String jersey,
			String teamID) {
		super();
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.jersey = jersey;
		TeamID = teamID;
	}

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getJersey() {
		return jersey;
	}

	public void setJersey(String jersey) {
		this.jersey = jersey;
	}

	public String getTeamID() {
		return TeamID;
	}

	public void setTeamID(String teamID) {
		TeamID = teamID;
	}
	
}
