package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Stammdaten.altersKategorie;
import Stammdaten.limiten;
import Start.MainApp;
import util.DateUtil;

/**
 * Dialog zum Anschauen der Limiten
 * 
 * @author Rudolf Brpger
 */
public class KategorieController {
	@FXML
	private TableView<limiten> katTable;

	@FXML
	private Label AlterskategorieLabel;

	@FXML
	private Label KatNameLabel;
	@FXML
	private Label MindestalterLabel;
	@FXML
	private Label HoechstalterLabel;
	@FXML
	private Label SortierungLabel;

	private ObservableList<altersKategorie> katData = FXCollections.observableArrayList();

	// referenziert auf die Main Applikation
	private MainApp mainApp;

	// Konstruktor
	public KategorieController() {

	}

	// ObservableList mit Daten befüllen
	public ObservableList<altersKategorie> getKatData() {
		return katData;
	}

	// Referenz auf MainApp setzen
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		katData.addAll(mainApp.getKatData());

	}

}
