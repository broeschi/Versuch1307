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
import stammdaten.limiten;
import start.MainApp;
import util.DateUtil;

/**
 * Dialog zum Anschauen der Limiten
 * 
 * @author Rudolf Brpger
 */
public class LimitenController {
	@FXML
	private TableView<limiten> limitTable;

	@FXML
	private Label KategorieLabel;

	@FXML
	private Label MinOpLabel;
	@FXML
	private Label MaxNullerLabel;
	@FXML
	private Label KarteOpLabel;
	@FXML
	private Label KarteFsLabel;
	@FXML
	private Label KranzFsLabel;
	@FXML
	private Label FigurFsLabel;

	private ObservableList<limiten> limitData = FXCollections.observableArrayList();

	// referenziert auf die Main Applikation
	private MainApp mainApp;

	// Konstruktor
	public LimitenController() {

	}

	// Controller initialisieren und daten in die ObservableList laden
	public void initialize() {
		limitTable.setItems(limitData);
	}

	public ObservableList<limiten> getLimitData() {
		return limitData;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
		limitData.addAll(mainApp.getLimitData());

	}

}
