package Person;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** Klasse zum Bilden der Teilnehmer*/
public class Person {
	
    private final StringProperty Vorname;
    private final StringProperty Name;
    //private final StringProperty Adresse;
    //private final IntegerProperty plz;
    //private final StringProperty city;
    //private final ObjectProperty<LocalDate> birthday;
    
    public Person() {
    	this (null, null);
    }
    
    public Person(String adrName, String adrVorname) {
        this.Name = new SimpleStringProperty(adrName);
        this.Vorname = new SimpleStringProperty(adrVorname);
        
        
    }
    
    

    public void setAdrName(String adrName) {
        this.Name.set(adrName);
    }

    public StringProperty NameProperty() {
        return Name;
    }



	/** Nachname des Teilnemers*/
	public String adrName;
	
	/** Vorname des Teilnemers*/
	public String adrVorname;
	
	/** Geburstdatum des Teilnemers*/
	public Date adrGebDat;
	
	/** Strasse des Teilnemers*/
	public String adrStrasse;
	
	/** Hausnummer des Teilnemers*/
	public Double adrNr;
	
	/** CH Postleitzahl des Teilnemers*/
	public Double adrPLZ;
	
	/** Wohnort des Teilnemers*/
	public String adrWohnort;
	
	
	

	public StringProperty getAdrName() {
		return adrName;
	}

	public void setAdrName(StringProperty adrName) {
		this.adrName = adrName;
	}

	public StringProperty getAdrVorname() {
		return adrVorname;
	}
	
	public StringProperty VornameProperty() {
		return adrVorname;
	}

	public void setAdrVorname(String vorname2) {
		this.adrVorname = vorname2;
	}

	public Date getAdrGebDat() {
		return adrGebDat;
	}

	public void setAdrGebDat(Date adrGebDat) {
		this.adrGebDat = adrGebDat;
	}

	public String getAdrStrasse() {
		return adrStrasse;
	}

	public void setAdrStrasse(String adrStrasse) {
		this.adrStrasse = adrStrasse;
	}

	public Double getAdrNr() {
		return adrNr;
	}

	public void setAdrNr(Double adrNr) {
		this.adrNr = adrNr;
	}

	public Double getAdrPLZ() {
		return adrPLZ;
	}

	public void setAdrPLZ(Double adrPLZ) {
		this.adrPLZ = adrPLZ;
	}

	public String getAdrWohnort() {
		return adrWohnort;
	}

	public void setAdrWohnort(String adrWohnort) {
		this.adrWohnort = adrWohnort;
	}
}
