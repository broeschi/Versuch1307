package GUI;


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
import Stammdaten.limiten;
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

	
	public LimitenController() {
		
	}
	public ObservableList<limiten> getLimitData() {
		return limitData;
	}

	
	private void initialize() {
		
		
		KategorieLabel.setText(limiten.getLimKatRef());
	}
	
	
	

}
