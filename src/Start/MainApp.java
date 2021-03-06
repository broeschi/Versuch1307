package Start;

import java.io.IOException;
import java.util.ArrayList;

import Person.Person;
import Person.Resultat;
import Stammdaten.altersKategorie;
import Stammdaten.limiten;
import Stammdaten.Waffen;
import datenbank.Datenbank;
import gui.LimitenController;
import gui.PersonController;
import gui.PersonMutierenController;
import gui.ResultatController;
import gui.RootLayoutController;
import gui.WaffenAuswahlController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Vereinsverwaltung");

		initRootLayout();

		showPersonOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showPersonOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/Person.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			// Give the controller access to the main app.
			PersonController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Zeigt die g�ltigen Limiten der Bundes�bungen an
	 */
	public void showLimitenDialog() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/Limiten.fxml"));
			AnchorPane limiten = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(limiten);

			// Give the controller access to the main app.
			LimitenController controller = loader.getController();
			controller.setMainApp(this); // hier gibt es einen NPE

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Zeigt das Mapping des Alters der Teilnehmer auf die Alterskategorien
	 */
	public void showAlterKatDialog() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/Alterskategorie.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			// Give the controller access to the main app.
			LimitenController controller = loader.getController();
			controller.setMainApp(this); // hier gibt es einen NPE

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * Anwendung starten
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Personendaten f�r gui in JavaFX laden
	 * 
	 * @return
	 */
	public ObservableList<Person> getPersonData() {

		return personData;
	}

	/**
	 * The data as an observable list of Persons.
	 */
	public ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * Constructor initiale Daten aus der DB laden
	 * 
	 * @throws Exception
	 */
	public MainApp() throws Exception {
		personData.addAll(datenbank.Datenbank.loadData());
		katData.addAll(datenbank.Datenbank.loadKat());
		limitData.addAll(datenbank.Datenbank.loadLim());
		waffenData.addAll(datenbank.Datenbank.loadWaf());

	}

	/**
	 * Opens a dialog to edit details for the specified person. If the user clicks
	 * OK, the changes are saved into the provided person object and true is
	 * returned.
	 * 
	 * @param person the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonMutierenDialog(Person person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/PersonMutieren.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sch�tzendaten �ndern");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			PersonMutierenController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Liste f�r die Tabelle mit den Limiten
	public ObservableList<limiten> limitData = FXCollections.observableArrayList();

	// Liste mit Daten der Limitentabelle mit Daten bef�llen
	public ObservableList<limiten> getLimitData() {

		return limitData;
	}

	// Liste f�r die Tabelle mit den Alterskategorien
	public static ObservableList<altersKategorie> katData = FXCollections.observableArrayList();

	// Liste mit Daten der Alterskategorien mit Daten bef�llen
	public static ObservableList<altersKategorie> getKatData() {
		try {
			datenbank.Datenbank.loadKat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return katData;
	}

	public void showDruckerEinstellungen() {

	}

	// Liste f�r die Auswahl in der Combobox mit den Waffenkategorien
	public ObservableList<Waffen> waffenData = FXCollections.observableArrayList();

	// Waffenliste mit Daten bef�llen
	public ObservableList<Waffen> getWaffenData() {
		try {
			datenbank.Datenbank.loadWaf();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return waffenData;
	}

	/**
	 * Zeigt den Auswahldialog mit den verf�gbaren Waffen an
	 */
	public boolean showWaffenDialog(Waffen waffe) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/WaffenAuswahl.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Waffe w�hlen");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Waffe im controller einsetzen
			WaffenAuswahlController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setWaffe(waffenData);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ObservableList<Resultat> getResultData() {

		return resultatData;
	}

	// Liste f�r die Tabelle mit den allen Resultaten
	public ObservableList<Resultat> resultatData = FXCollections.observableArrayList();

	// Liste mit Resultatdaten bef�llen
	public ObservableList<Resultat> getResData() {
		return resultatData;
	}

	/**
	 * �ffent den Dialog f�r die Erfassung oder Mutation der geschossenen Resultate
	 * 
	 * @param selectedResultat
	 * @return
	 */
	public boolean showReslutatView(Resultat selectedResultat) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/gui/ResultatForm.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Resultat eingeben und speichern");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			ResultatController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setResultat(resultatData);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
