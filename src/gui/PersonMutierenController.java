package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Person.*;
import util.DateUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonMutierenController {

	@FXML
	private TextField NameField;

	@FXML
	private TextField VornameField;

	@FXML
	private TextField AdresseField;

	@FXML
	private TextField AdresseNrField;

	@FXML
	private TextField plzField;

	@FXML
	private TextField WohnortField;

	@FXML
	private TextField GeburtsdatumField;

	@FXML
	private TextField AHVField;

	@FXML
	private TextField EinteilungField;

	@FXML
	private TextField GradField;

	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 * 
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;

		VornameField.setText(person.getAdrVorname());
		NameField.setText(person.getAdrName());
		AdresseField.setText(person.getAdrStrasse());
		AdresseNrField.setText(person.getAdrNr());
		plzField.setText(Integer.toString(person.getAdrPLZ()));
		WohnortField.setText(person.getAdrWohnort());
		GeburtsdatumField.setText(DateUtil.format(person.getGebDat()));
		GeburtsdatumField.setPromptText("dd.mm.yyyy");
		AHVField.setText(person.getAdrAHV());
		EinteilungField.setText(person.getAdrEint());
		GradField.setText(person.getAdrGrad());
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setAdrVorname(VornameField.getText());
			person.setAdrName(NameField.getText());
			person.setAdrStrasse(AdresseField.getText());
			person.setAdrNr(AdresseField.getText());
			person.setAdrPlz(Integer.parseInt(plzField.getText()));
			person.setAdrWohnort(WohnortField.getText());
			person.setGebDat(DateUtil.parse(GeburtsdatumField.getText()));
			person.setAdrAHV(AHVField.getText());
			person.setAdrGrad(GradField.getText());
			person.setAdrEint(EinteilungField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (VornameField.getText() == null || VornameField.getText().length() == 0) {
			errorMessage += "Bitte Vornamen eingeben.";
		}
		if (NameField.getText() == null || NameField.getText().length() == 0) {
			errorMessage += "Bitte Namen eingeben";
		}
		if (AdresseField.getText() == null || AdresseField.getText().length() == 0) {
			errorMessage += "Bitte Strasse eingeben";
		}

		if (AdresseNrField.getText() == null || AdresseNrField.getText().length() == 0) {
			errorMessage += "Bitte Hausnummer eingeben";
		}

		if (plzField.getText() == null || plzField.getText().length() == 0) {
			errorMessage += "Bitte PLZ eingeben";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(plzField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Bitte gültige PLZ eingeben. Es muss eine Zahl sein";
			}
		}

		if (WohnortField.getText() == null || WohnortField.getText().length() == 0) {
			errorMessage += "Bitte Wohnort eingeben";
		}

		if (GeburtsdatumField.getText() == null || GeburtsdatumField.getText().length() == 0) {
			errorMessage += "Bitte gültiges Geburtsdatum eingeben";
		} else {
			if (!DateUtil.validDate(GeburtsdatumField.getText())) {
				errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
