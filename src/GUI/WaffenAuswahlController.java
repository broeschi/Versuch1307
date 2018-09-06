package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.DateUtil;
import Person.Person;
import Stammdaten.waffen;
import Start.MainApp;

/**
 * Dialog zur Auswahl und Einsetzen der Waffe
 * 
 * @author Rudolf Broger
 *
 */
public class WaffenAuswahlController {
	@FXML
	private TableView<waffen> waffenTable;

	@FXML
	private ComboBox<String> waffenComboOp;

	@FXML
	private ComboBox<String> waffenComboFs;

	private ObservableList<waffen> waffenData = FXCollections.observableArrayList();

	private Stage dialogStage;
	private boolean okClicked = false;

	// referentziert auf die MainApp
	private MainApp mainApp;

	public WaffenAuswahlController() {

	}

	public void initialize() {
		waffenTable.setItems(waffenData);

	}

	public ObservableList<waffen> getWaffenData() {
		return waffenData;
	}

	public void setMainApp(MainApp manApp) {
		this.mainApp = mainApp;
		// Observable Liste hinzufügen
		waffenData.addAll(mainApp.getWaffenData());
	}

	@FXML
	private void handleOk() {

		okClicked = true;
		dialogStage.close();
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

}
