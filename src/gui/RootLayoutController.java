package gui;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import Start.MainApp;

public class RootLayoutController {
	// Reference to the main application
	private Start.MainApp mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Start.MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		mainApp.getPersonData().clear();

	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Access files (*.accdb)", "*.accdb");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// mainApp.loadPersonDataFromFile(file);
		}
	}

	/**
	 * Saves the file to the person file that is currently open. If there is no open
	 * file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleSave() {
		// File personFile = mainApp.getPersonFilePath();
		// if (personFile != null) {
		// mainApp.savePersonDataToFile(personFile);
		// } else {
		// handleSaveAs();
		// }
	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		// FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML
		// files (*.xml)", "*.xml");
		// fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		// File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		// if (file != null) {
		// Make sure it has the correct extension
		// if (!file.getPath().endsWith(".xml")) {
		// file = new File(file.getPath() + ".xml");
		// }
		// mainApp.savePersonDataToFile(file);
		// }
	}

	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("�ber");
		alert.setHeaderText("Vereinsverwaltung");
		alert.setContentText("Author: Rudolf Broger");

		alert.showAndWait();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}

	@FXML
	private void handleStandblatt() {
		mainApp.showPersonOverview();

	}

	@FXML
	private void handleLimite() {
		mainApp.showLimitenDialog();

	}

	@FXML
	private void handleAlterKat() {
		mainApp.showAlterKatDialog();
	}

	@FXML
	private void handleDrucker() {
		mainApp.showDruckerEinstellungen();
	}

}
