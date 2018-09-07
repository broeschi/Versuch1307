package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Stammdaten.Waffen;
import Start.MainApp;

/**
 * Dialog zur Auswahl und Einsetzen der Waffe
 * 
 * @author Rudolf Broger
 *
 */
public class WaffenAuswahlController {
	@FXML
	private TableView<Waffen> waffenTable;

	@FXML
	private ChoiceBox<String> waffenChoiceOp;

	@FXML
	private ChoiceBox<String> waffenChoiceFs;

	private ObservableList<Waffen> waffenData = FXCollections.observableArrayList();
	private ChoiceBox<String> waffenName = new ChoiceBox<String>();

	private Stage dialogStage;
	private ObservableList<Waffen> waffe;
	private boolean okClicked = false;

	// referentziert auf die MainApp
	private MainApp mainApp;

	public WaffenAuswahlController() {

	}

	public void initialize() {

	}
	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	public ObservableList<Waffen> getWaffenData() {
		return waffenData;
	}

	public void setMainApp(MainApp mainApp) {
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
	
	@FXML
	private void gugus(ActionEvent event) {
		ChoiceBox<String> waffenName = new ChoiceBox<String>();
		ObservableList<String> waffenData = FXCollections.observableArrayList();
		waffenName.setItems(waffenData);
	}

	public void setWaffen(ObservableList<Waffen> waffe) {
		this.waffe = waffe;
		
	}

	public boolean isOkClicked() {
		return okClicked;
	}



}
