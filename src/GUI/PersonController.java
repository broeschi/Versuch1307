package GUI;

import datenbank.Datenbank;
//import ch.makery.address.model.Person;
//import ch.makery.adress.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Person.Person;
//import ch.makery.adress.util.DateUtil;


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
	
	
	
    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	try {
			Datenbank.loadData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
   public void setPerson(Person person) {
        this.person = person;

        VornameField.setText(person.getAdrVorname());
        NameField.setText(person.getAdrName());
 //       streetField.setText(person.getStreet());
 //       postalCodeField.setText(Integer.toString(person.getPostalCode()));
 //       cityField.setText(person.getCity());
 //       birthdayField.setText(DateUtil.format(person.getBirthday()));
 //       birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
  //  @FXML
  //  private void handleOk() {
  //      if (isInputValid()) {
  //          person.setFirstName(firstNameField.getText());
  //          person.setLastName(lastNameField.getText());
  //          person.setStreet(streetField.getText());
  //          person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
  //          person.setCity(cityField.getText());
  //          person.setBirthday(DateUtil.parse(birthdayField.getText()));
//
//            okClicked = true;
//            dialogStage.close();
 //       }
 

}
