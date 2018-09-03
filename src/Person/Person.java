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

/** Klasse zum Bilden der Teilnehmer */
public class Person {

	private final IntegerProperty adrId;
	private final StringProperty adrVorname;
	private final StringProperty adrName;
	private final StringProperty adrStrasse;
	private final StringProperty adrNr;
	private final IntegerProperty adrPLZ;
	private final StringProperty adrWohnort;
	private final ObjectProperty<LocalDate> adrGebDat;
	private final StringProperty adrAHV;
	private final StringProperty adrMilEinteilung;
	private final StringProperty adrGrad;

	public Person(Integer adrId, String adrName, String adrVorname, String adrStrasse, LocalDate adrGebDat,
			String adrNr, Integer adrPLZ, String adrWohnort, String adrAHV, String adrEint, String adrGrad) {
		this.adrId = new SimpleIntegerProperty(adrId);
		this.adrName = new SimpleStringProperty(adrName);
		this.adrVorname = new SimpleStringProperty(adrVorname);
		this.adrStrasse = new SimpleStringProperty(adrStrasse);
		this.adrNr = new SimpleStringProperty(adrNr);
		this.adrPLZ = new SimpleIntegerProperty(adrPLZ);
		this.adrWohnort = new SimpleStringProperty(adrWohnort);
		this.adrGebDat = new SimpleObjectProperty<LocalDate>(adrGebDat);
		this.adrAHV = new SimpleStringProperty(adrAHV);
		this.adrMilEinteilung = new SimpleStringProperty(adrEint);
		this.adrGrad = new SimpleStringProperty(adrGrad);

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

	public IntegerProperty adrIdProperty() {
		return adrId;
	}

	public void setAdrId(Integer adrId) {
		this.adrId.set(adrId);
		;
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

	public StringProperty AdrAHVProperty() {
		return adrAHV;
	}

	public String getAdrAHV() {
		return adrAHV.get();
	}

	public void setAdrAHV(String adrAHV) {
		this.adrAHV.set(adrAHV);
	}

	public StringProperty adrMilEinteilung() {
		return adrMilEinteilung;
	}

	public String getAdrEint() {
		return adrMilEinteilung.get();
	}

	public void setAdrEint(String adrEint) {
		this.adrMilEinteilung.set(adrEint);
	}

	public StringProperty AdrGradProperty() {
		return adrGrad;
	}

	public String getAdrGrad() {
		return adrGrad.get();
	}

	public void setAdrGrad(String adrGrad) {
		this.adrGrad.set(adrGrad);
	}

	public ObjectProperty<LocalDate> adrGebDatProperty() {
		return adrGebDat;
	}

	public LocalDate getGebDat() {
		return adrGebDat.get();
	}

	public void setGebDat(LocalDate adrGebDat) {
		this.adrGebDat.set(adrGebDat);
	}

}
