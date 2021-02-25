
public class JerseySortTable {
	String playerID, firstName, lastName, position, jersey, TeamID;

	public JerseySortTable(String playerID, String firstName, String lastName, String position, String jersey,
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
