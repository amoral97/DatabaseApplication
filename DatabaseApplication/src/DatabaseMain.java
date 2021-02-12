
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMain {

	private static String databaseURL = "jdbc:derby:DatabaseApplication;create=true";
	
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(databaseURL);
			Statement statement = connection.createStatement()) {

			
			statement.execute(SqlPlayer.dropTable());
			statement.execute(SqlPlayer.createTable());
			statement.execute(SqlPlayer.insertData());
			ResultSet playerResults = statement.executeQuery(SqlPlayer.allData());
			printPlayerData(playerResults);

			statement.execute(SqlTeam.dropTable());
			statement.execute(SqlTeam.createTable());
			statement.execute(SqlTeam.insertData());
			ResultSet teamResults = statement.executeQuery(SqlTeam.allData());
			printTeamData(teamResults);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void printPlayerData(ResultSet results) throws SQLException {
		System.out.println("Player Data:");
		System.out.println("ID  FirstName LastName Position      Jersey TeamID");
		System.out.println("---------------------------------------------------");

		while (results.next()) {
			int id = results.getInt("ID");
			String firstName = results.getString("FirstName");
			String lastName = results.getString("LastName");
			String position = results.getString("Position");
			int jerseyNumber = results.getInt("JerseyNumber");
			int teamID = results.getInt("TeamID");
			System.out.printf("%3d %-9s %-8s %-13s %-7d %d%n", id, firstName, lastName, position, jerseyNumber, teamID);
		}
		System.out.println();
	}
	
	private static void printTeamData(ResultSet results) throws SQLException {
		System.out.println("Team Data:");
		System.out.println("ID Name     City      Mascot");
		System.out.println("------------------------------");

		while (results.next()) {
			int id = results.getInt("ID");
			String name = results.getString("Name");
			String city = results.getString("City");
			String mascot = results.getString("Mascot");
			System.out.printf("%-2d %-8s %-9s %-7s %n", id, name, city, mascot);
		}
		System.out.println();
	}
}
