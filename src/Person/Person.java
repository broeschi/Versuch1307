package Person;

import java.util.Date;

/** Klasse zum Bilden der Teilnehmer*/
public class Person {
	
	public Person(String adrName, String adrVorname, Date adrGebDat, String adrStrasse, Double adrNr, Double adrPLZ,
			String adrWohnort) {
		super();
		this.adrName = adrName;
		this.adrVorname = adrVorname;
		this.adrGebDat = adrGebDat;
		this.adrStrasse = adrStrasse;
		this.adrNr = adrNr;
		this.adrPLZ = adrPLZ;
		this.adrWohnort = adrWohnort;
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

	public String getAdrName() {
		return adrName;
	}

	public void setAdrName(String adrName) {
		this.adrName = adrName;
	}

	public String getAdrVorname() {
		return adrVorname;
	}

	public void setAdrVorname(String adrVorname) {
		this.adrVorname = adrVorname;
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
