package GUI;

import org.apache.commons.lang.StringUtils;

import Person.Person;
import Person.Resultat;
import Start.MainApp;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
	private TextField ResultatOpField;

	@FXML
	private TextField AnzNullerOpField;

	@FXML
	private TextField ResWhg1OpField;

	@FXML
	private TextField AnzNullerWhg1Field;

	@FXML
	private TextField ResWhg2OpField;

	@FXML
	private TextField AnzNullerWhg2Field;

	@FXML
	private TextField ResultatFsField;

	@FXML
	private TextField FigurentrefferFsField;
	
	private boolean okClicked = false;
	private Stage dialogStage;
	private Resultat resultat;

	private static ObservableList<Person> personData = FXCollections.observableArrayList();

	private static ObservableList<Resultat> resultatData = FXCollections.observableArrayList();

	// referenziert auf die Main Applikation
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public ResultatController() {

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
	 * GUI-Felder schreiben
	 * 
	 * @param resultat
	 */
	public void setResultat(Resultat resultat) {
		if (resultat != null) {
			this.resultat = resultat;

			
			ResultatOpField.setText(getNonNull(resultat.getResOp()));
			AnzNullerOpField.setText(getNonNull(resultat.getResAnzNullerOp()));
			ResWhg1OpField.setText(getNonNull(resultat.getResWhg1()));
			AnzNullerWhg1Field.setText(getNonNull(resultat.getResAnzNullerW1Op()));
			ResWhg2OpField.setText(getNonNull(resultat.getResWhg2()));
			AnzNullerWhg2Field.setText(getNonNull(resultat.getResAnzNullerW2Op()));
			ResultatFsField.setText(getNonNull(resultat.getResFs()));
			FigurentrefferFsField.setText(getNonNull(resultat.getResFigFs()));
		
			NameLabel.setText(resultat.getPerson().getAdrName());
			VornameLabel.setText(resultat.getPerson().getAdrVorname());
			AdresseLabel.setText(resultat.getPerson().getAdrStrasse());
			AdresseNrLabel.setText(resultat.getPerson().getAdrNr());
			plzLabel.setText(resultat.getPerson().getAdrPLZ().toString());
			WohnortLabel.setText(resultat.getPerson().getAdrWohnort());
			GeburtsdatumLabel.setText(DateUtil.format(resultat.getPerson().getGebDat()));
			AHVLabel.setText(resultat.getPerson().getAdrAHV());
			EinteilungLabel.setText(resultat.getPerson().getAdrEint());
			GradLabel.setText(resultat.getPerson().getAdrGrad());

		}

	}

	public String getNonNull(StringProperty  property) {
		return property.getValue() == null ? "" :  property.getValue();
	}

	/**
	 * Neu erfasste oder geänderte Eintrage in die ObservableList speichern
	 */
	@FXML
	private void handleOk() {
		resultat.setResOp(ResultatOpField.getText());
		resultat.setResOpNull(AnzNullerOpField.getText());
		resultat.setResWhg1(ResWhg1OpField.getText());
		resultat.setResOpW1Null(AnzNullerWhg1Field.getText());
		resultat.setResWhg2(ResWhg2OpField.getText());
		resultat.setResOpW2Null(AnzNullerWhg2Field.getText());
		resultat.setResFs(ResultatFsField.getText());
		resultat.setResFigFs(FigurentrefferFsField.getText());
		
		okClicked = true;
		dialogStage.close();

	}

}
