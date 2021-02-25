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
    public static ResultSet playersFromCity(String city) throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT p.ID, p.FirstName, p.LastName, p.Position, p.JerseyNumber, p.TeamID, t.City " +
                    "FROM Player p " +
                    "INNER JOIN Team t ON p.TeamID = t.ID AND t.City = '"+city+"'");

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


    /**
     * Takes in a Player ID and a Team ID and updates the team the player is associated.
     * @param pId
     * @param tId
     * @throws SQLException
     */
    public static void updatePlayerTeam(int pId, int tId) throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            statement.executeUpdate("UPDATE Player "
                    + "SET TeamID = "+tId+" "
                    + "WHERE ID = "+pId+"");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Takes in Player information such as First Name, Last Name, Position, Jersey Number, and Team ID and inserts a single player.
     * @param fName
     * @param lName
     * @param pos
     * @param jNum
     * @param tId
     * @throws SQLException
     */
    public static void insertPlayer(String fName, String lName, String pos, int jNum, int tId) throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            statement.execute("INSERT INTO Player "
                    + "(FirstName, LastName, Position, JerseyNumber, TeamID) "
                    + "VALUES ('"+fName+"', '"+lName+"', '"+pos+"', "+jNum+", "+tId+")");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in a Player ID and deletes the Player from the Database
     * @param pId
     * @throws SQLException
     */
    public static void deletePlayer(int pId) throws SQLException {
        Connection connect = DBConnector.getConnection();
        try  {
            Statement statement = connect.createStatement();
            statement.execute("DELETE FROM Player "
                    + "WHERE ID = "+pId+"");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
