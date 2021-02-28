
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
			+ "('Paul', 'Crade', 'Power Forward', 26, 1),"
			+ "('Chris', 'Parker', 'Point Guard', 5, 3),"
			+ "('Bob', 'Jones', 'Small Foward', 2, 0),"
			+ "('Dan', 'Longhurst', 'Center', 22, 0),"
			+ "('Edward', 'Pain', 'Shooting Guard', 31, 0),"
			+ "('Jimmy', 'Neutron', 'Power Forward', 6, 0),"
			+ "('Jordan', 'Lane', 'Center', 13, 1),"
			+ "('Adam', 'Stevenson', 'Small Forward', 18, 1),"
			+ "('Oscar', 'Holder', 'Power Forward', 29, 2),"
			+ "('Carlos', 'Kerr', 'Center', 92, 3),"
			+ "('Max', 'Apex', 'Small Foward', 22, 4),"
			+ "('Junior', 'Morley', 'Center', 11, 2),"
			+ "('Alex', 'Davis', 'Shooting Guard', 1, 4),"
			+ "('Sam', 'Watson', 'Shooting Guard', 77, 1),"
			+ "('Henry', 'Jackson', 'Shooting Guard', 8, 2),"
			+ "('Jose', 'Lions', 'Small Forward', 9, 3),"
			+ "('Bryson', 'Evans', 'Power Forward', 20, 3),"
			+ "('Aaron', 'Ross', 'Shooting Guard', 40, 3),"
			+ "('Carson', 'Malone', 'Point Guard', 37, 2),"
			+ "('David', 'Evanston', 'Point Guard', 57, 1),"
			+ "('Steven', 'Boris', 'Center', 70, 4),"
			+ "('Tom', 'Benson', 'Power Forward', 95, 4),"
			+ "('Brayden', 'Camerons', 'Point Guard', 55, 4),"
			+ "('Drew', 'Cash', 'Small Forward', 42, 2)";
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
