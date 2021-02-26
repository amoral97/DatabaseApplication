
public class CityFilterTable {
	String playerID, firstName, lastName, position, jersey, TeamID, city;

	public CityFilterTable(String playerID, String firstName, String lastName, String position, String jersey,
			String teamID, String city) {
		super();
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.jersey = jersey;
		this.city = city;
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
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}
