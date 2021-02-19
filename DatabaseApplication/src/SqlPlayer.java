
public class SqlPlayer {
	public static String createTable() {
		return "CREATE TABLE Player " 
			+ "(ID int not null primary key " 
			+ "GENERATED ALWAYS AS IDENTITY "
			+ "(START WITH 100, INCREMENT BY 1), "
			+ "FirstName varchar(255),"
			+ "LastName varchar(255),"
			+ "Position varchar(255),"
			+ "JerseyNumber int,"
			+ "TeamID int"
			+ ")";
	}
	
	public static String dropTable()
	{
		return "DROP TABLE Player";
	}
	
	public static String insertData() {
		return "INSERT INTO Player "
			+ "(FirstName, LastName, Position, JerseyNumber, TeamID)"
			+ "VALUES ('John', 'Maxwell', 'Point Guard', 14, 0),"
			+ "('Paul', 'Crade', 'Power Forward', 26, 2),"
			+ "('Chris', 'Parker', 'Center', 5, 1)";
	}
	
	public static String allData() {
		return "SELECT * FROM Player";
	}
	
	public static String addEntry(String firstName, String lastName, String position, String jerseyNumber, String teamID) {
		return "INSERT INTO Player "
				+ "(FirstName, LastName, Position, JerseyNumber, TeamID)"
				+ "VALUES ('" + firstName + "', '" + lastName + "', '" + position + "', " + jerseyNumber + ", " + teamID + " )";
	}
	
	public static String deleteEntry(String playerID)
	{
		return "DELETE FROM Player WHERE ID = " + playerID + "";
	}
	
	public static String changeEntry(String playerID, String firstName, String lastName, String position, String jerseyNumber, String teamID)
	{
		return "UPDATE Player "
			 + "SET FirstName = '"+ firstName +"', "
			 + "LastName = '"+ lastName +"', "
			 + "Position = '"+ position +"', "
			 + "JerseyNumber = "+ jerseyNumber +", "
			 + "TeamID = "+ teamID +" "
			 + "WHERE ID = " + playerID + "";
	}
}
