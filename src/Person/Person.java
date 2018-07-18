package Person;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/** Klasse zum Bilden der Teilnehmer*/
public class Person {
	
    private final StringProperty adrVorname;
    private final StringProperty adrName;
    //private final StringProperty Adresse;
    //private final IntegerProperty plz;
    //private final StringProperty city;
    //private final ObjectProperty<LocalDate> birthday;
    
    public Person() {
    	this (null, null);
    	
    }
    
    public Person(String adrName, String adrVorname) {
        this.adrName = new SimpleStringProperty(adrName);
        this.adrVorname = new SimpleStringProperty(adrVorname);
            
    }
    
    




	
	
	
	

	public StringProperty AdrNameProperty() {
		return adrName;
	}

	public String getAdrName() {
		return adrName.get();
	}

	public void setAdrName(String adrName) {
		this.adrName.set(adrName);
	}

	public StringProperty AdrVornameProperty() {
		return adrVorname;
	}
	
	public String getAdrVorname() {
		return adrVorname.get();
	}
	
	
	public StringProperty VornameProperty() {
		return adrVorname;
	}
	
	public void setAdrVorname(String adrVorname) {
		this.adrVorname.set(adrVorname);
	}


}
