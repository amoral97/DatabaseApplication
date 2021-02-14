
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DatabaseMain extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	/*
	 * private static void printPlayerData(ResultSet results) throws SQLException {
	 * System.out.println("Player Data:");
	 * System.out.println("ID  FirstName LastName Position      Jersey TeamID");
	 * System.out.println("---------------------------------------------------");
	 * 
	 * while (results.next()) { int id = results.getInt("ID"); String firstName =
	 * results.getString("FirstName"); String lastName =
	 * results.getString("LastName"); String position =
	 * results.getString("Position"); int jerseyNumber =
	 * results.getInt("JerseyNumber"); int teamID = results.getInt("TeamID");
	 * System.out.printf("%3d %-9s %-8s %-13s %-7d %d%n", id, firstName, lastName,
	 * position, jerseyNumber, teamID); } System.out.println(); }
	 * 
	 * private static void printTeamData(ResultSet results) throws SQLException {
	 * System.out.println("Team Data:");
	 * System.out.println("ID Name     City      Mascot");
	 * System.out.println("------------------------------");
	 * 
	 * while (results.next()) { int id = results.getInt("ID"); String name =
	 * results.getString("Name"); String city = results.getString("City"); String
	 * mascot = results.getString("Mascot");
	 * System.out.printf("%-2d %-8s %-9s %-7s %n", id, name, city, mascot); }
	 * System.out.println(); }
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Table.fxml"));
		Scene sc = new Scene(root);

		primaryStage.setScene(sc);
		primaryStage.show();
	}
}
