import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database Handler, Has methods in it to return results from Player or Team tables in certain formats.
 */
public class DatabaseHandler {

    /**
     * Queries and then returns Players info along with Team City as a ResultSet and Placed it in ascending order based on City Name
     * @return
     * @throws SQLException
     */
    public static ResultSet playersFromCity() throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT p.ID, p.FirstName, p.LastName, p.Position, p.JerseyNumber, p.TeamID, t.City " +
                    "FROM Player p " +
                    "LEFT JOIN Team t ON p.TeamID = t.ID " +
                    "ORDER BY t.City ASC");

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Queries and then returns Players info Sorted by Jersey Number in Ascending order
     * @return
     * @throws SQLException
     */
    public static ResultSet playerJerseyOrder() throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT ID, FirstName, LastName, Position, JerseyNumber, TeamID " +
                    "FROM Player " +
                    "ORDER BY JerseyNumber ASC");

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Queries and then returns Players info along with Team info as a ResultSet
     * @return
     * @throws SQLException
     */
    public static ResultSet playersTeam() throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT p.ID, p.FirstName, p.LastName, p.Position, p.JerseyNumber, p.TeamID, t.City, t.Name, t.Mascot " +
                    "FROM Player p " +
                    "LEFT JOIN Team t ON p.TeamID = t.ID " +
                    "ORDER BY t.Name ASC");

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
