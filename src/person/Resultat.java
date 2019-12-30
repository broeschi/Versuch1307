package person;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * Klasse für Resultate
 * 
 * @author Ruedi Broger
 *
 */
public class Resultat {
	private IntegerProperty res_id;

	public void setRes_id(IntegerProperty res_id) {
		this.res_id = res_id;
	}

	private final IntegerProperty resJahr;
	private final IntegerProperty resAdrref;
	private final StringProperty resWfRefOp;
	private final StringProperty resWfRefFs;
	private final StringProperty resAlter;
	private final StringProperty resLimRef;
	private final StringProperty resOp;
	private final StringProperty resWhg1;
	private final StringProperty resWhg2;
	private final StringProperty resAnzNullerOp;
	private final StringProperty resAnzNullerW1Op;
	private final StringProperty resAnzNullerW2Op;
	private final StringProperty resFs;
	private final StringProperty resFigFs;

	/**
	 * Konstruktor für die übergabe einer einzelnen Referenz auf eine bestimmte
	 * person
	 * 
	 * @param resAdrref Fremdschlüssel/Referenz in Resultat auf Person 
	 */
	public Resultat(Integer resAdrref) {
		this.res_id = new SimpleIntegerProperty();
		this.resJahr = new SimpleIntegerProperty();
		this.resAdrref = new SimpleIntegerProperty(resAdrref);
		this.resWfRefOp = new SimpleStringProperty();
		this.resWfRefFs = new SimpleStringProperty();
		this.resAlter = new SimpleStringProperty();
		this.resLimRef = new SimpleStringProperty();
		this.resOp = new SimpleStringProperty();
		this.resWhg1 = new SimpleStringProperty();
		this.resWhg2 = new SimpleStringProperty();
		this.resAnzNullerOp = new SimpleStringProperty();
		this.resAnzNullerW1Op = new SimpleStringProperty();
		this.resAnzNullerW2Op = new SimpleStringProperty();
		this.resFs = new SimpleStringProperty();
		this.resFigFs = new SimpleStringProperty();
	}

	/**
	 * vollständiger Konstruktor des Datenmodells für die Erfassung der
	 * Resultatwerte
	 * 
	 * @param res_id Primärschlüssel des Resultats
	 * @param resJahr Zuordnung Resultat zum Jahr der Teilnahme
	 * @param resAdrref Fremdschlüssel zum Zuordnen des Resultats zur Person
	 * @param resWfRefOp Referenz zu Waffe beim OP
	 * @param resWfRefFs Referenz zu Waffe beim FS
	 * @param resAlter Relevantes Alter der Person
	 * @param resLimRef Referenz zu den erforderlichen Limiten
	 * @param resOp Resultat OP
	 * @param resWhg1 Resultat der 1. Wiederholung
	 * @param resWhg2 Reslutat der 2. Wiederholung
	 * @param resAnzNullerOp Anzahl geschossener 0 beim OP
	 * @param resAnzNullerW1Op Anzahl geschossener 0 beim OP 1. Wiederholung
	 * @param resAnzNullerW2Op Anzahl geschossener 0 beim OP 2. Wiederholung
	 * @param resFs Resultat FS
	 * @param resFigFs Anzahl der Figurentreffer beim FS
	 */
	public Resultat(Integer res_id, Integer resJahr, Integer resAdrref, Integer resWfRefOp, Integer resWfRefFs,
			Integer resAlter, Integer resLimRef, Integer resOp, Integer resWhg1, Integer resWhg2,
			Integer resAnzNullerOp, Integer resAnzNullerW1Op, Integer resAnzNullerW2Op, Integer resFs,
			Integer resFigFs) {
		this.res_id = new SimpleIntegerProperty(res_id);
		this.resJahr = new SimpleIntegerProperty(resJahr);
		this.resAdrref = new SimpleIntegerProperty(resAdrref);
		this.resWfRefOp = createStringProperty(resOp);
		this.resWfRefFs = createStringProperty(resWfRefFs);
		this.resAlter = createStringProperty(resAlter);
		this.resLimRef = createStringProperty(resLimRef);
		this.resOp = createStringProperty(resOp);
		this.resWhg1 = createStringProperty(resWhg1);
		this.resWhg2 = createStringProperty(resWhg2);
		this.resAnzNullerOp = createStringProperty(resAnzNullerOp);
		this.resAnzNullerW1Op = createStringProperty(resAnzNullerW1Op);
		this.resAnzNullerW2Op = createStringProperty(resAnzNullerW2Op);
		this.resFs = createStringProperty(resFs);
		this.resFigFs = createStringProperty(resFigFs);

	}

	/**
	 * Methode zum Auslagern der Typenzuweisung der Parameter des Konstruktors
	 * 
	 * @param value
	 * @return
	 */
	private SimpleStringProperty createStringProperty(Integer value) {
		if (value == null) {
			return new SimpleStringProperty("");
		} else {
			return new SimpleStringProperty(String.valueOf(value));
		}
	}

	public IntegerProperty getRes_id() {
		return res_id;
	}

	public IntegerProperty resJahrProperty() {
		return resJahr;
	}

	public Integer getResJahr() {
		return resJahr.get();
	}

	public void setResJahr(Integer resJahr) {
		this.resJahr.set(resJahr);
	}

	public IntegerProperty getResAdrref() {
		return resAdrref;
	}

	public StringProperty resWfRefOpProperty() {
		return resWfRefOp;
	}

	public StringProperty resWfRefFsProperty() {
		return resWfRefFs;
	}

	public StringProperty resAlterProperty() {
		return resAlter;
	}

	public StringProperty resLimRefProperty() {
		return resLimRef;
	}

	public StringProperty resOpProperty() {
		return resOp;
	}

	public void setResOp(String resOp) {
		this.resOp.set(resOp);
	}

	public StringProperty resWhg1Property() {
		return resWhg1;
	}

	public void setResWhg1(String resWhg1) {
		this.resWhg1.set(resWhg1);
	}

	public StringProperty resWhg2Property() {
		return resWhg2;
	}

	public void setResWhg2(String resWhg2) {
		this.resWhg2.set(resWhg2);
	}

	public StringProperty resAnzNullerProperty() {
		return resAnzNullerOp;
	}

	public void setResOpNull(String resOpNull) {
		this.resAnzNullerOp.set(resOpNull);
	}

	public void setResOpW1Null(String resOpW1Null) {
		this.resAnzNullerW1Op.set(resOpW1Null);
	}

	public void setResOpW2Null(String resOpW2Null) {
		this.resAnzNullerW2Op.set(resOpW2Null);
	}

	public StringProperty resFsProperty() {
		return resFs;
	}

	public void setResFs(String resFs) {
		this.resFs.set(resFs);
	}

	public StringProperty resFigFsProperty() {
		return resFigFs;
	}

	public void setResFigFs(String resFigFs) {
		this.resFigFs.set(resFigFs);
	}

	public StringProperty getResWfRefOp() {
		return resWfRefOp;
	}

	public StringProperty getResWfRefFs() {
		return resWfRefFs;
	}

	public StringProperty getResAlter() {
		return resAlter;
	}

	public StringProperty getResLimRef() {
		return resLimRef;
	}

	public StringProperty getResOp() {
		return resOp;
	}

	public StringProperty getResWhg1() {
		return resWhg1;
	}

	public StringProperty getResWhg2() {
		return resWhg2;
	}

	public StringProperty getResAnzNullerOp() {
		return resAnzNullerOp;
	}

	public StringProperty getResAnzNullerW1Op() {
		return resAnzNullerW1Op;
	}

	public StringProperty getResAnzNullerW2Op() {
		return resAnzNullerW2Op;
	}

	public StringProperty getResFs() {
		return resFs;
	}

	public StringProperty getResFigFs() {
		return resFigFs;
	}

}
