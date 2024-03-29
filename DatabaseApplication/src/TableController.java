import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TableController implements Initializable {
	/**
	 * Links the GUI elements to corresponding variables such as the Table element
	 * and TableColumn elements. Plus, initiates an ObservableList for easier table
	 * processing.
	 */
	@FXML private VBox PlayerTableBox;
	@FXML private AnchorPane QueriesPane;
	@FXML private VBox cityFilterBox;
	@FXML private StackPane tableStackPane;
	@FXML private TextArea cityFilterTextArea;

	// this is a really gross way to do it
	@FXML private TableView<PlayerTable> table;
	@FXML private TableColumn<PlayerTable, String> col_playerID;
	@FXML private TableColumn<PlayerTable, String> col_firstName;
	@FXML private TableColumn<PlayerTable, String> col_lastName;
	@FXML private TableColumn<PlayerTable, String> col_position;
	@FXML private TableColumn<PlayerTable, String> col_jersey;
	@FXML private TableColumn<PlayerTable, String> col_teamID;

	@FXML private TableView<TeamSortTable> teamSortTable;
	@FXML private TableColumn<TeamSortTable, String> col_playerIDTeam;
	@FXML private TableColumn<TeamSortTable, String> col_firstNameTeam;
	@FXML private TableColumn<TeamSortTable, String> col_lastNameTeam;
	@FXML private TableColumn<TeamSortTable, String> col_positionTeam;
	@FXML private TableColumn<TeamSortTable, String> col_jerseyTeam;
	@FXML private TableColumn<TeamSortTable, String> col_teamIDTeam;
	@FXML private TableColumn<TeamSortTable, String> col_cityTeam;
	@FXML private TableColumn<TeamSortTable, String> col_teamNameTeam; 
	@FXML private TableColumn<TeamSortTable, String> col_mascotTeam;

	@FXML private TableView<JerseySortTable> jerseySortTable;
	@FXML private TableColumn<JerseySortTable, String> col_playerIDJersey;
	@FXML private TableColumn<JerseySortTable, String> col_firstNameJersey;
	@FXML private TableColumn<JerseySortTable, String> col_lastNameJersey;
	@FXML private TableColumn<JerseySortTable, String> col_positionJersey;
	@FXML private TableColumn<JerseySortTable, String> col_jerseyJersey;
	@FXML private TableColumn<JerseySortTable, String> col_teamIDJersey;

	@FXML private TableView<CityFilterTable> cityFilterTable;
	@FXML private TableColumn<CityFilterTable, String> col_playerIDCity;
	@FXML private TableColumn<CityFilterTable, String> col_firstNameCity;
	@FXML private TableColumn<CityFilterTable, String> col_lastNameCity;
	@FXML private TableColumn<CityFilterTable, String> col_positionCity;
	@FXML private TableColumn<CityFilterTable, String> col_jerseyCity;
	@FXML private TableColumn<CityFilterTable, String> col_teamIDCity;
	@FXML private TableColumn<CityFilterTable, String> col_cityCity;

	@FXML private Button playerButton;
	@FXML private Button teamButton;
	@FXML private Button jerseyButton;
	@FXML private Button cityButton;

	@FXML private Button entryCreateButton;
	@FXML private TextArea addEntryFirstName;
	@FXML private TextArea addEntryLastName;
	@FXML private TextArea addEntryPosition;
	@FXML private TextArea addEntryJerseyNumber;
	@FXML private TextArea addEntryTeamID;

	@FXML private Button entryDeleteButton;
	@FXML private TextArea entryRemoveIDText;

	@FXML private Button confirmChangesButton;
	@FXML private TextArea changeEntryFirstName;
	@FXML private TextArea changeEntryLastName;
	@FXML private TextArea changeEntryPosition;
	@FXML private TextArea changeEntryJerseyNumber;
	@FXML private TextArea changeEntryTeamID;

	ObservableList<PlayerTable> playerList = FXCollections.observableArrayList();
	ObservableList<JerseySortTable> jerseyList = FXCollections.observableArrayList();
	ObservableList<TeamSortTable> teamList = FXCollections.observableArrayList();
	ObservableList<CityFilterTable> cityList = FXCollections.observableArrayList();

	/**
	 * Allows the controller to retrieve database information and adds them to their
	 * corresponding GUI columns. Sets all of the list items to the TableView so
	 * they can be displayed on the GUI.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try (Connection connect = DBConnector.getConnection(); Statement statement = connect.createStatement()) {

			
			/*
			 * statement.execute(SqlPlayer.dropTable());
			 * statement.execute(SqlPlayer.createTable());
			 * statement.execute(SqlPlayer.insertData());
			 * 
			 * statement.execute(SqlTeam.dropTable());
			 * statement.execute(SqlTeam.createTable());
			 * statement.execute(SqlTeam.insertData());
			 */
			 
			
			ResultSet rs = statement.executeQuery(SqlPlayer.allData());
			ResultSet jerseySet = DatabaseHandler.playerJerseyOrder();
			ResultSet teamSet = DatabaseHandler.playersTeam();
			ResultSet citySet = DatabaseHandler.playersFromCity();

			while (rs.next()) {
				playerList.add(
						new PlayerTable(rs.getString("ID"), rs.getString("FirstName"), rs.getString("LastName"),
						rs.getString("Position"), rs.getString("JerseyNumber"), rs.getString("TeamID")
						));
			}

			while (jerseySet.next()) {
				jerseyList.add(
						new JerseySortTable(jerseySet.getString("ID"), jerseySet.getString("FirstName"),
						jerseySet.getString("LastName"), jerseySet.getString("Position"),
						jerseySet.getString("JerseyNumber"), jerseySet.getString("TeamID")
						));
			}

			while (teamSet.next()) {
				teamList.add(
						new TeamSortTable(teamSet.getString("ID"), teamSet.getString("FirstName"),
						teamSet.getString("LastName"), teamSet.getString("Position"), teamSet.getString("JerseyNumber"),
						teamSet.getString("TeamID"), teamSet.getString("City"), teamSet.getString("Name"),
						teamSet.getString("Mascot")
						));
			}
			
			while (citySet.next()) {
				cityList.add(
						new CityFilterTable(citySet.getString("ID"), citySet.getString("FirstName"), citySet.getString("LastName"), citySet.getString("Position"), 
						citySet.getString("JerseyNumber"), citySet.getString("TeamID"), citySet.getString("City"))
						);
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		setPlayerTableData();
		setJerseyTableData();
		setTeamTableData();
		setCityTableData();
		filterData();

		PlayerTableBox.toFront();
		cityFilterBox.toBack();
		teamSortTable.toBack();
		jerseySortTable.toBack();
	}

	// Table Selections
	public void playerTableView() {
		PlayerTableBox.toFront();
		cityFilterBox.toBack();
		teamSortTable.toBack();
		jerseySortTable.toBack();
	}

	public void teamTableView() {
		PlayerTableBox.toBack();
		cityFilterBox.toBack();
		teamSortTable.toFront();
		jerseySortTable.toBack();
	}

	public void jerseyTableView() {
		PlayerTableBox.toBack();
		cityFilterBox.toBack();
		teamSortTable.toBack();
		jerseySortTable.toFront();
	}

	public void cityTableView() {
		PlayerTableBox.toBack();
		cityFilterBox.toFront();
		teamSortTable.toBack();
		jerseySortTable.toBack();
	}

	// Set String values from ObservableList to TableView columns
	public void setPlayerTableData() {
		col_playerID.setCellValueFactory(new PropertyValueFactory<>("playerID"));
		col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
		col_jersey.setCellValueFactory(new PropertyValueFactory<>("jersey"));
		col_teamID.setCellValueFactory(new PropertyValueFactory<>("teamID"));

		table.setItems(playerList);
	}

	public void setJerseyTableData() {
		col_playerIDJersey.setCellValueFactory(new PropertyValueFactory<>("playerID"));
		col_firstNameJersey.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		col_lastNameJersey.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		col_positionJersey.setCellValueFactory(new PropertyValueFactory<>("position"));
		col_jerseyJersey.setCellValueFactory(new PropertyValueFactory<>("jersey"));
		col_teamIDJersey.setCellValueFactory(new PropertyValueFactory<>("teamID"));

		jerseySortTable.setItems(jerseyList);
	}

	public void setTeamTableData() {
		col_playerIDTeam.setCellValueFactory(new PropertyValueFactory<>("playerID"));
		col_firstNameTeam.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		col_lastNameTeam.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		col_positionTeam.setCellValueFactory(new PropertyValueFactory<>("position"));
		col_jerseyTeam.setCellValueFactory(new PropertyValueFactory<>("jersey"));
		col_teamIDTeam.setCellValueFactory(new PropertyValueFactory<>("teamID"));
		col_cityTeam.setCellValueFactory(new PropertyValueFactory<>("city"));
		col_teamNameTeam.setCellValueFactory(new PropertyValueFactory<>("teamName"));
		col_mascotTeam.setCellValueFactory(new PropertyValueFactory<>("mascot"));

		teamSortTable.setItems(teamList);
	}
	
	public void setCityTableData() {
		col_playerIDCity.setCellValueFactory(new PropertyValueFactory<>("playerID"));
		col_firstNameCity.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		col_lastNameCity.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		col_positionCity.setCellValueFactory(new PropertyValueFactory<>("position"));
		col_jerseyCity.setCellValueFactory(new PropertyValueFactory<>("jersey"));
		col_teamIDCity.setCellValueFactory(new PropertyValueFactory<>("teamID"));
		col_cityCity.setCellValueFactory(new PropertyValueFactory<>("city"));

		cityFilterTable.setItems(cityList);
	}
	
    // Adds filtering functionality to the CityFilterTable with the TextArea <code>cityFIlterTextArea</code>
	public void filterData() {
		FilteredList<CityFilterTable> fList = new FilteredList<>(cityList, b -> true);

		// Key listener to handle what happens to the list whenever the filter changes
		cityFilterTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
			fList.setPredicate(cityFilterTable -> {
				String lcFilter = newValue.toLowerCase();
				
				// @Returns true when filter equals the city
				if (cityFilterTable.getCity().toLowerCase().indexOf(lcFilter) != -1) {
					return true;
				} else
					return false;
			});
		});
		
		SortedList<CityFilterTable> sList = new SortedList<>(fList);
		
		sList.comparatorProperty().bind(cityFilterTable.comparatorProperty());
		cityFilterTable.setItems(sList);
	}

	public void entryCreate() {
		if (addEntryFirstName.getText() != "" && addEntryLastName.getText() != "" && addEntryPosition.getText() != ""
				&& addEntryJerseyNumber.getText() != "" && addEntryTeamID.getText() != "") {
			// Adds entry to database
			try (Connection connect = DBConnector.getConnection(); Statement statement = connect.createStatement()) {

				statement.executeUpdate(SqlPlayer.addEntry(addEntryFirstName.getText(), addEntryLastName.getText(),
						addEntryPosition.getText(), addEntryJerseyNumber.getText(), addEntryTeamID.getText()));

				ResultSet rs = statement.executeQuery(SqlPlayer.allData());

				// clears list and reassigns the values to be displayed
				playerList.clear();
				while (rs.next()) {
					playerList.add(
							new PlayerTable(rs.getString("ID"), rs.getString("FirstName"), rs.getString("LastName"),
									rs.getString("Position"), rs.getString("JerseyNumber"), rs.getString("TeamID")));
				}

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			addEntryFirstName.clear();
			addEntryLastName.clear();
			addEntryPosition.clear();
			addEntryJerseyNumber.clear();
			addEntryTeamID.clear();
		}
	}

	public void entryRemove() {
		if (entryRemoveIDText.getText() != null) {
			try (Connection connect = DBConnector.getConnection(); Statement statement = connect.createStatement()) {

				statement.execute(SqlPlayer.deleteEntry(entryRemoveIDText.getText()));
				ResultSet rs = statement.executeQuery(SqlPlayer.allData());

				// clears list and reassigns the values to be displayed
				playerList.clear();
				while (rs.next()) {
					playerList.add(
							new PlayerTable(rs.getString("ID"), rs.getString("FirstName"), rs.getString("LastName"),
									rs.getString("Position"), rs.getString("JerseyNumber"), rs.getString("TeamID")));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			entryRemoveIDText.clear();
		}
	}

	public void entryTextPopulate() {
		if (table.getSelectionModel().getSelectedItem() != null) {
			changeEntryFirstName.setText(table.getSelectionModel().getSelectedItem().getFirstName());
			changeEntryLastName.setText(table.getSelectionModel().getSelectedItem().getLastName());
			changeEntryPosition.setText(table.getSelectionModel().getSelectedItem().getPosition());
			changeEntryJerseyNumber.setText(table.getSelectionModel().getSelectedItem().getJersey());
			changeEntryTeamID.setText(table.getSelectionModel().getSelectedItem().getTeamID());
			entryRemoveIDText.setText(table.getSelectionModel().getSelectedItem().getPlayerID());
		}
	}

	public void entryChange() {
		if (table.getSelectionModel().getSelectedItem() != null) {

			try (Connection connect = DBConnector.getConnection(); Statement statement = connect.createStatement()) {

				// Add new entry
				statement.execute(SqlPlayer.changeEntry(table.getSelectionModel().getSelectedItem().getPlayerID(),
						changeEntryFirstName.getText(), changeEntryLastName.getText(), changeEntryPosition.getText(),
						changeEntryJerseyNumber.getText(), changeEntryTeamID.getText()));

				ResultSet rs = statement.executeQuery(SqlPlayer.allData());

				// clears list and reassigns the values to be displayed
				playerList.clear();
				while (rs.next()) {
					playerList.add(
							new PlayerTable(rs.getString("ID"), rs.getString("FirstName"), rs.getString("LastName"),
									rs.getString("Position"), rs.getString("JerseyNumber"), rs.getString("TeamID")));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
