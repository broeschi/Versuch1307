package GUI;

import datenbank.Datenbank;
//import ch.makery.address.model.Person;
//import ch.makery.adress.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
            // showPersonDetails(null);

            // Listen for selection changes and show the person details when changed.
    		personTable.getSelectionModel().selectedItemProperty().addListener(
    				(observable, oldValue, newValue) -> showPersonDetails(newValue));
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
                //streetLabel.setText(person.getStreet());
                //postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
                //cityLabel.setText(person.getCity());
                //birthdayLabel.setText(DateUtil.format(person.getBirthday()));
               
            } else {
                // Person is null, remove all the text.
                VornameLabel.setText("");
                NameLabel.setText("");
                //streetLabel.setText("");
                //postalCodeLabel.setText("");
                //cityLabel.setText("");
                //birthdayLabel.setText("");
            }
        }


	public boolean isOkClicked() {
		// TODO Auto-generated method stub
		return false;
	}

    
    


 
 
  

}
