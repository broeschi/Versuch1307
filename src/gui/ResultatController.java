package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import person.Person;
import person.Resultat;
import start.MainApp;
import util.DateUtil;

/**
 * Resultat von einzelnen Personen bearbeiten
 * 
 * @author Rudolf Broger
 *
 */
public class ResultatController {

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
	private Label ResultatOpLabel;

	@FXML
	private Label AnzNullerOpLabel;

	@FXML
	private Label ResWhg1OpLabel;

	@FXML
	private Label AnzNullerWhg1Label;

	@FXML
	private Label ResWhg2OpLabel;

	@FXML
	private Label AnzNullerWhg2Label;

	@FXML
	private Label ResultatFsLabel;

	@FXML
	private Label FigurentrefferFsLabel;
	private boolean okClicked = false;
	private Stage dialogStage;
	private ObservableList<Person> person;
	private ObservableList<Resultat> resultat;

	private static ObservableList<Person> personData = FXCollections.observableArrayList();

	private static ObservableList<Resultat> resultatData = FXCollections.observableArrayList();

	// referenziert auf die Main Applikation
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public ResultatController() {
		// personData.addAll(mainApp.getPersonData());
		// resultatData.addAll(mainApp.getResultData());

	}

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

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personData.addAll(mainApp.getPersonData());
		resultatData.addAll(mainApp.getResultData());
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Vorhandene Werte aus ObservableList Resultat in die enstsprechenden
	 * gui-Felder schreiben
	 * 
	 * @param resultat
	 */
	public void setResultat(ObservableList<Resultat> resultat) {
		this.resultat = resultat;

		ResultatOpLabel.setText(((Resultat) resultat).getResOp().toString());
		AnzNullerOpLabel.setText(((Resultat) resultat).getResAnzNullerOp().toString());
		ResWhg1OpLabel.setText(((Resultat) resultat).getResWhg1().toString());
		AnzNullerWhg1Label.setText(((Resultat) resultat).getResAnzNullerW1Op().toString());
		ResWhg2OpLabel.setText(((Resultat) resultat).getResWhg2().toString());
		AnzNullerWhg2Label.setText(((Resultat) resultat).getResAnzNullerW2Op().toString());
		ResultatFsLabel.setText(((Resultat) resultat).getResFs().toString());
		FigurentrefferFsLabel.setText(((Resultat) resultat).getResFigFs().toString());

	}

	/**
	 * Neu erfasste oder geänderte Eintrage in die ObservableList speichern
	 */
	@FXML
	private void handleSpeichern() {
		((Resultat) resultat).setResOp(ResultatOpLabel.getText());
		((Resultat) resultat).setResOpNull(AnzNullerOpLabel.getText());
		((Resultat) resultat).setResWhg1(ResWhg1OpLabel.getText());
		((Resultat) resultat).setResOpW1Null(AnzNullerWhg1Label.getText());
		((Resultat) resultat).setResWhg2(ResWhg2OpLabel.getText());
		((Resultat) resultat).setResOpW2Null(AnzNullerWhg2Label.getText());
		((Resultat) resultat).setResFs(ResultatFsLabel.getText());
		((Resultat) resultat).setResFigFs(FigurentrefferFsLabel.getText());

		dialogStage.close();

	}

}
