package testStepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stich.Stich;


public class TestschritteStichErstellen {
	
	StichErstellen stichErstellen = new StichErstellen();
	
	@Given("^Vereinsverwaltung laeuft$")
	public void vereinsverwaltung_laeuft throws Exception {
		System.out.println("Vereinsverwaltung l�uft");
		neuerStichErstellen();
	}
	@When("^Ich w�hle neuen Stich erstellen$")
	public void neuerStichErstellen() throws Exception {
		
	}
	@Then("^�ffnet sich ein Fenster$")
	public void fensterOeffnen() throws Exception {
		
	}
	@Then("^der Stich wird sequenzweise erfasst$")
	public void stichSequenziellErfassen() throws Exception {
		
	}

}
