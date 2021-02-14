import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Separate class for getting the SQL connection string.
 *
 */
public class DBConnector {

	private static String databaseURL = "jdbc:derby:DatabaseApplication;create=true";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(databaseURL);

		return connection;
	}
}
