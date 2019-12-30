package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import stammdaten.Waffen;
import start.MainApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	private ChoiceBox<Waffen> choiceBoxOp;
	private ObservableList<Waffen> waffenData = FXCollections.observableArrayList();

	private Stage dialogStage;
	private Waffen waffe;
	private boolean okClicked = false;

	// referenziert auf die MainApp
	private MainApp mainApp;

	public WaffenAuswahlController() {

	}

	/**
	 * Controller initialisieren und vorhandene Daten in die Auswahlbox schreiben
	 */
	public void initialize() {
		choiceBoxOp.setItems(waffenData);
		// waffenTable.setItems(waffenData);
	}

	@FXML
	private void handleChoiceBoxAction() {
		Waffen selectedWaffe = choiceBoxOp.getSelectionModel().getSelectedItem();

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage Sets the stage of this dialog
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Waffenkategorien in die ObservableList eintragen
	 * 
	 * @return Waffenliste
	 */
	public ObservableList<Waffen> getWaffenData() {
		return waffenData;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
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

	public boolean isOkClicked() {
		return okClicked;
	}

	public void setWaffe(ObservableList<Waffen> waffenData) {
		// TODO Auto-generated method stub

	}

}
