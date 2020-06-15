package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import stich.Stich;
import stich.StichSequenz;

public class StichController {
	@FXML
	private TextField StichNameField;
	
	@FXML
	private TableColumn<Stich, String> StichNameColumn;
	
	private static ObservableList<Stich> stichData = FXCollections.observableArrayList();

	private static ObservableList<StichSequenz> stichSequenzData = FXCollections.observableArrayList();
	
	public StichController() {
		//Stich initialisieren
		StichNameColumn.setCellValueFactory(cellData -> cellData.getValue().StichNameProperty());
	}



}
