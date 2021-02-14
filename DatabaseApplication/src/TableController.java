import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable {
	/**
	 * Links the GUI elements to corresponding variables such as the Table element
	 * and TableColumn elements. Plus, initiates an ObservableList for easier table
	 * processing.
	 */
	@FXML
	private TableView<PlayerTable> table;
	@FXML
	private TableColumn<PlayerTable, String> col_playerID;
	@FXML
	private TableColumn<PlayerTable, String> col_firstName;
	@FXML
	private TableColumn<PlayerTable, String> col_lastName;
	@FXML
	private TableColumn<PlayerTable, String> col_position;
	@FXML
	private TableColumn<PlayerTable, String> col_jersey;
	@FXML
	private TableColumn<PlayerTable, String> col_teamID;

	ObservableList<PlayerTable> list = FXCollections.observableArrayList();

	/**
	 * Allows the controller to retrieve database information and adds them to their
	 * corresponding GUI columns. Sets all of the list items to the TableView so
	 * they can be displayed on the GUI.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try (Connection connect = DBConnector.getConnection(); Statement statement = connect.createStatement()) {

			statement.execute(SqlPlayer.dropTable());
			statement.execute(SqlPlayer.createTable());
			statement.execute(SqlPlayer.insertData());
			ResultSet rs = statement.executeQuery(SqlPlayer.allData());

			while (rs.next()) {
				list.add(new PlayerTable(rs.getString("ID"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Position"), rs.getString("JerseyNumber"), rs.getString("TeamID")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		col_playerID.setCellValueFactory(new PropertyValueFactory<>("playerID"));
		col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
		col_jersey.setCellValueFactory(new PropertyValueFactory<>("jersey"));
		col_teamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));

		table.setItems(list);

	}
}
