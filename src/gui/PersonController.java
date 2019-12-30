package gui;

import datenbank.Datenbank;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Cell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import person.Person;
import person.Resultat;
import start.MainApp;

import java.io.IOException;

/**
 * Detailinfo der Personen bearbeiten
 * 
 * @author Rudolf Broger
 *
 */
public class PersonController {

	@FXML
	private TextField NameField;

	@FXML
	private TextField VornameField;

	@FXML
	private TableView<Person> personTable;

	@FXML
	private TableView<Resultat> resultTable;

	@FXML
	private TableColumn<Person, String> VornameColumn;

	@FXML
	private TableColumn<Person, String> NameColumn;

	@FXML
	private Label VornameLabel;

	@FXML
	private Label NameLabel;

	@FXML
	private Label AdresseLabel;

	@FXML
	private Label AdresseNrLabel;

	@FXML
	private Label plzLabel;

	@FXML
	private Label WohnortLabel;

	@FXML
	private Label GeburtsdatumLabel;

	@FXML
	private Label AHVLabel;

	@FXML
	private Label EinteilungLabel;

	@FXML
	private Label GradLabel;

	@FXML
	private TableColumn<Resultat, Number> JahrColumn;

	@FXML
	private TableColumn<Resultat, String> OpColumn;

	@FXML
	private TableColumn<Resultat, String> FsColumn;

	@FXML
	private TableColumn<Resultat, String> OpNullerColumn;

	@FXML
	private TableColumn<Resultat, String> Whg1Column;

	@FXML
	private TableColumn<Resultat, String> OpWhg1NullerColumn;

	@FXML
	private TableColumn<Resultat, String> Whg2Column;

	@FXML
	private TableColumn<Resultat, String> OpWhg2NullerColumn;

	@FXML
	private TableColumn<Resultat, String> FigColumn;

	@FXML
	private TextField filterField;

	@FXML
	private TableColumn<Person, String> firstNameColumn;

	@FXML
	private TableColumn<Person, String> lastNameColumn;

	private static ObservableList<Person> personData = FXCollections.observableArrayList();

	private static ObservableList<Resultat> resultatData = FXCollections.observableArrayList();

	// referenziert auf die Main Applikation
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public PersonController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		VornameColumn.setCellValueFactory(cellData -> cellData.getValue().VornameProperty());
		NameColumn.setCellValueFactory(cellData -> cellData.getValue().AdrNameProperty());

		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Person> filteredData = new FilteredList<>(personData, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (person.getAdrVorname().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (person.getAdrName().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});

		// 3. Wrap the FilteredList in a SortedList.
		SortedList<Person> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		sortedData.comparatorProperty().bind(personTable.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		personTable.setItems(sortedData);

		// Clear person details.
		showPersonDetails(null);

		// Listen for selection changes and show the person details when changed.
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personData.addAll(mainApp.getPersonData());
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param person the person or null
	 */
	void showPersonDetails(Person person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			VornameLabel.setText(person.getAdrVorname());
			NameLabel.setText(person.getAdrName());
			AdresseLabel.setText(person.getAdrStrasse());
			AdresseNrLabel.setText(person.getAdrNr());
			plzLabel.setText(Integer.toString(person.getAdrPLZ()));
			WohnortLabel.setText(person.getAdrWohnort());
			GeburtsdatumLabel.setText(DateUtil.format(person.getGebDat()));
			AHVLabel.setText(person.getAdrAHV());
			EinteilungLabel.setText(person.getAdrEint());
			GradLabel.setText(person.getAdrGrad());
			try {
				resultatData.clear();
				resultatData.addAll(datenbank.Datenbank.loadRes(person));
				resultTable.setItems(resultatData);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JahrColumn.setCellValueFactory(cellData -> cellData.getValue().resJahrProperty());
			OpColumn.setCellValueFactory(cellData -> cellData.getValue().resOpProperty());
			Whg1Column.setCellValueFactory(cellData -> cellData.getValue().resWhg1Property());
			Whg2Column.setCellValueFactory(cellData -> cellData.getValue().resWhg2Property());
			FsColumn.setCellValueFactory(cellData -> cellData.getValue().resFsProperty());
			FigColumn.setCellValueFactory(cellData -> cellData.getValue().resFigFsProperty());
			OpNullerColumn.setCellValueFactory(cellData -> cellData.getValue().getResAnzNullerOp());
			OpWhg1NullerColumn.setCellValueFactory(cellData -> cellData.getValue().getResAnzNullerW1Op());
			OpWhg2NullerColumn.setCellValueFactory(cellData -> cellData.getValue().getResAnzNullerW2Op());

		} else {
			// person is null, remove all the text.
			VornameLabel.setText("");
			NameLabel.setText("");
			AdresseLabel.setText("");
			AdresseNrLabel.setText("");
			plzLabel.setText("");
			WohnortLabel.setText("");
			GeburtsdatumLabel.setText("");
			AHVLabel.setText("");
			EinteilungLabel.setText("");
			GradLabel.setText("");

		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit details
	 * for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		Person tempPerson = new Person();
		boolean okClicked = mainApp.showPersonMutierenDialog(tempPerson);
		if (okClicked) {
			personData.add(tempPerson);
			try {
				datenbank.Datenbank.saveDataP(tempPerson);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit details
	 * for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showPersonMutierenDialog(selectedPerson);
			if (okClicked) {
				try {
					datenbank.Datenbank.updateDataP(selectedPerson);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Ermittelt das Alter der person, ordnet sie einer Alterskategorie zu und
	 * steigt das Menu zur Auswahl des Sportgeräts. Es wird eine neue Zeile in der
	 * Resultattabelle in der DB angelegt.
	 * 
	 * @throws Exception
	 */
	@FXML
	private void handleStandblattPerson() throws Exception {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			int alter = logik.Berechnungen.alterSetzen(selectedPerson.adrGebDat);
			int alterKat = logik.Berechnungen.alterKategorieSetzen(alter);
			mainApp.showWaffenDialog(null);
			try {
				datenbank.Datenbank.saveDataR(selectedPerson, alter);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("keine person wurde ausgewählt");
			alert.setContentText("Bitte gewünschte person auswählen.");
			alert.showAndWait();
		}

	}

	/**
	 * öffnet das Eingabefenster zu, Erfassen der Resultate und speichert dies in
	 * die DB
	 */
	@FXML
	private void handleResultatPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			Resultat selectedResultat = resultTable.getSelectionModel().getSelectedItem();
			mainApp.showReslutatView(selectedResultat);
			try {
				datenbank.Datenbank.updateDataR(selectedResultat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Keine Auswahl");
			alert.setHeaderText("keine person wurde ausgewählt");
			alert.setContentText("Bitte gewünschte person auswählen.");
			alert.showAndWait();
		}

	}

	public boolean isOkClicked() {
		return false;
	}

}
