
public class SqlTeam {
	public static String createTable() {
		return "CREATE TABLE Team " 
			+ "(ID int not null primary key " 
			+ "GENERATED ALWAYS AS IDENTITY "
			+ "(START WITH 0, INCREMENT BY 1), "
			+ "Name varchar(255),"
			+ "City varchar(255),"
			+ "Mascot varchar(255)"
			+ ")";
	}
	
	public static String dropTable()
	{
		return "DROP TABLE Team";
	}
	
	public static String insertData() {
		return "INSERT INTO Team "
			+ "(Name, City, Mascot)"
			+ "VALUES ('Nets', 'Brooklyn', 'Duncan'),"
			+ "('Heat', 'Miami', 'Burnie'),"
			+ "('Celtics', 'Boston', 'Lucky')";
	}
	
	public static String allData() {
		return "SELECT * FROM Team";
	}
}
