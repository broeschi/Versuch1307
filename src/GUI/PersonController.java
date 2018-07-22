package GUI;

import datenbank.Datenbank;
//import ch.makery.address.model.Person;
//import ch.makery.adress.util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import Person.Person;
//import ch.makery.adress.util.DateUtil;
import Start.MainApp;


/**
 * Detailinfo der Personen bearbeiten
 * 
 * @author Rudolf Broger
 *
 */

public class PersonController {
	
	
	@FXML
    private TextField NameField;
	
	@FXML
    private TextField VornameField;
	
	@FXML
    private TableView<Person> personTable;
	
	@FXML
    private TableColumn<Person, String> VornameColumn;

	@FXML
    private TableColumn<Person, String> NameColumn;
	
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
	
	// referenziert auf die Main Applikation
    private MainApp mainApp;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonController() {
    }


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	  	// Initialize the person table with the two columns.
            VornameColumn.setCellValueFactory(cellData -> cellData.getValue().VornameProperty());
            NameColumn.setCellValueFactory(cellData -> cellData.getValue().AdrNameProperty());
            
            // Clear person details.
            showPersonDetails(null);

            // Listen for selection changes and show the person details when changed.
    		personTable.getSelectionModel().selectedItemProperty().addListener(
    				(observable, oldValue, newValue) -> showPersonDetails(newValue));
        }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * the name to search a person.
     */
    @FXML
    private void handleSearchPerson() {
    	try{
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/GUI/PersonSuchen.fxml"));
            AnchorPane ps = (AnchorPane) loader.load();
            
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Person suchen");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(ps);
	        dialogStage.setScene(scene);
     
                
                
                
                
          } catch (IOException e) {
            e.printStackTrace();
            }
        }

        
    

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
        private void showPersonDetails(Person person) {
            if (person != null) {
                // Fill the labels with info from the person object.
                VornameLabel.setText(person.getAdrVorname());
                NameLabel.setText(person.getAdrName());
                AdresseLabel.setText(person.getAdrStrasse());
                AdresseNrLabel.setText(person.getAdrNr());
                plzLabel.setText(Integer.toString(person.getAdrPLZ()));
                WohnortLabel.setText(person.getAdrWohnort());
                //birthdayLabel.setText(DateUtil.format(person.getBirthday()));
               
            } else {
                // Person is null, remove all the text.
                VornameLabel.setText("");
                NameLabel.setText("");
                AdresseLabel.setText("");
                AdresseNrLabel.setText("");
                plzLabel.setText("");
                WohnortLabel.setText("");
                //birthdayLabel.setText("");
            }
        }


	public boolean isOkClicked() {
		// TODO Auto-generated method stub
		return false;
	}

    
    


 
 
  

}
