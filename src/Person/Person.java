package Person;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/** Klasse zum Bilden der Teilnehmer*/
public class Person {
	
    private final LongProperty adrId;
    private final StringProperty adrVorname;
    private final StringProperty adrName;
    private final StringProperty adrStrasse;
    private final StringProperty adrNr;
    private final IntegerProperty adrPLZ;
    private final StringProperty adrWohnort;
    //private final StringProperty city;
    //private final ObjectProperty<LocalDate> birthday;
    
    
    public Person(long adrId, String adrName, String adrVorname, String adrStrasse, String adrNr, int adrPLZ , String adrWohnort) {
        this.adrId = new SimpleLongProperty(adrId);
        this.adrName = new SimpleStringProperty(adrName);
        this.adrVorname = new SimpleStringProperty(adrVorname);
        this.adrStrasse = new SimpleStringProperty(adrStrasse);
        this.adrNr = new SimpleStringProperty(adrNr);
        this.adrPLZ = new SimpleIntegerProperty(adrPLZ);
        this.adrWohnort = new SimpleStringProperty(adrWohnort);
        
            
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

	

	public String getAdrVorname() {
		return adrVorname.get();
	}
	
	public StringProperty VornameProperty() {
		return adrVorname;
	}
	
	public void setAdrVorname(String adrVorname) {
		this.adrVorname.set(adrVorname);
	}
	
	
	public String getAdrStrasse() {
		return adrStrasse.get();
	}
	
	public StringProperty StrasseProperty() {
		return adrStrasse;
	}
	
	public void setAdrStrasse(String adrStrasse) {
		this.adrStrasse.set(adrStrasse);
	}
	
	public String getAdrNr() {
		return adrNr.get();
	}
	
	public StringProperty adrNrProperty() {
		return adrNr;
	}
	
	public void setAdrNr(String adrNr) {
		this.adrNr.set(adrNr);
	}


	
	public long getAdrId() {
		return adrId.get();
	}
	
	public LongProperty adrIdProperty() {
		return adrId;
	}
	
	public void setAdrId(long adrId) {
		this.adrId.set(adrId);;
	}


	public Integer getAdrPLZ() {
		return adrPLZ.get();
	}
	
	public IntegerProperty adrPLZProperty() {
		return adrPLZ;
	}
	
	public void setAdrPlz(Integer adrPLZ) {
		this.adrPLZ.set(adrPLZ);
	}
	
	public String getAdrWohnort() {
		return adrWohnort.get();
	}
	
	public StringProperty WohnortProperty() {
		return adrWohnort;
	}
	
	public void setAdrWohnort(String adrWohnort) {
		this.adrWohnort.set(adrWohnort);
	}



}
