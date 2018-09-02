package GUI;

import datenbank.Datenbank;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
//import ch.makery.address.model.Person;
import util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Cell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import Person.Person;
import Person.resultat;
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
	
	@FXML
	private Label GeburtsdatumLabel;
	
	@FXML
	private Label AHVLabel;
	
	@FXML
	private Label EinteilungLabel;

	@FXML
	private Label GradLabel;
	
	@FXML
	private TableColumn<resultat, Integer> JahrColumn;


	@FXML
	private TextField filterField;

	@FXML
    private TableColumn<Person, String> firstNameColumn;
    
	@FXML
    private TableColumn<Person, String> lastNameColumn;

    private static ObservableList<Person> personFilter = FXCollections.observableArrayList();

	
	// referenziert auf die Main Applikation
    private MainApp mainApp;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonController() {
    	
;    }


    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	  	// Initialize the person table with the two columns.
            VornameColumn.setCellValueFactory(cellData -> cellData.getValue().VornameProperty());
            NameColumn.setCellValueFactory(cellData -> cellData.getValue().AdrNameProperty());
            
            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Person> filteredData = new FilteredList<>(personFilter, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            filterField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(person -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (person.getAdrVorname().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (person.getAdrName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Person> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(personTable.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            personTable.setItems(sortedData);

            
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
        // 0. Initialize the columns.
        VornameColumn.setCellValueFactory(cellData -> cellData.getValue().VornameProperty());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().AdrNameProperty());

    	
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Person> filteredData = new FilteredList<>(personFilter, p -> true);
        //personFilter.addAll(mainApp.getPersonData());
        

        // 2. Set the filter Predicate whenever the filter changes.
        
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getAdrVorname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getAdrName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Person> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        personTable.setItems(sortedData);
    }
    	
    	//Person selectedPerson = personTable.getSelectionModel().getSelectedItems();
    	 //mainApp.showPersonSuchen(null);
    	//String name = new String();
    	//name = NameField.getText();
    	//PersonSuchenController.initialize();
    	//ObservableList<Person> filter =  FXCollections.observableArrayList();
    	
    	//((PersonController) filter).setPersonenList(MainApp.personData);
    	
    
    	
    	//try{
    	//	FXMLLoader loader = new FXMLLoader();
        //    loader.setLocation(MainApp.class.getResource("/GUI/PersonSuchen.fxml"));
        //    AnchorPane ps = (AnchorPane) loader.load();
            
	   //     Stage dialogStage = new Stage();
	   //     dialogStage.setTitle("Person suchen");
	   //     dialogStage.initModality(Modality.WINDOW_MODAL);
	   //     //dialogStage.initOwner(primaryStage);
	   //     Scene scene = new Scene(ps);
	   //     dialogStage.setScene(scene);
     
                
                
                
                
       //   } catch (IOException e) {
       //     e.printStackTrace();
       //     }
        

        
    

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
        void showPersonDetails(Person person) {
            if (person != null) {
                // Fill the labels with info from the person object.
                VornameLabel.setText(person.getAdrVorname());
                NameLabel.setText(person.getAdrName());
                AdresseLabel.setText(person.getAdrStrasse());
                AdresseNrLabel.setText(person.getAdrNr());
                plzLabel.setText(Integer.toString(person.getAdrPLZ()));
                WohnortLabel.setText(person.getAdrWohnort());
                GeburtsdatumLabel.setText(DateUtil.format(person.getGebDat()));
                AHVLabel.setText(person.getAdrAHV());
                EinteilungLabel.setText(person.getAdrEint());
                GradLabel.setText(person.getAdrGrad());
                try {
					//datenbank.Datenbank.loadRes();
					 //JahrColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("resJahr"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
               
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

    
	public ObservableList<Person> setPersonenList(ObservableList<Person> personData) {
		ObservableList<Person> personFilter = FXCollections.observableArrayList();
		personFilter.addAll(personData);
		return personFilter;
	}    


 
 
  

}
