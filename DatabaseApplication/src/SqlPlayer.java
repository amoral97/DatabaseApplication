
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
}
