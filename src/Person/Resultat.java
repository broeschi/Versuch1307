package Person;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Klasse für Resultate
 * 
 * @author Ruedi Broger
 *
 */
public class Resultat {
	private final IntegerProperty res_id;
	private final IntegerProperty resJahr;
	private final IntegerProperty resAdrref;
	private final StringProperty resWfRefOp;
	private final StringProperty resWfRefFs;
	private final StringProperty resAlter;
	private final StringProperty resLimRef;
	private final StringProperty resOp;
	private final StringProperty resWhg1;
	private final StringProperty resWhg2;
	private final StringProperty resAnzNuller;
	private final StringProperty resFs;
	private final StringProperty resFigFs;

	public Resultat(Integer res_id, Integer resJahr, Integer resAdrref, Integer resWfRefOp, Integer resWfRefFs,
			Integer resAlter, Integer resLimRef, Integer resOp, Integer resWhg1, Integer resWhg2, Integer resAnzNuller,
			Integer resFs, Integer resFigFs) {
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
		this.resAnzNuller = createStringProperty(resAnzNuller);
		this.resFs = createStringProperty(resFs);
		this.resFigFs = createStringProperty(resFigFs);

	}

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

	public StringProperty resWhg1Property() {
		return resWhg1;
	}

	public StringProperty resWhg2Property() {
		return resWhg2;
	}

	public StringProperty resAnzNullerProperty() {
		return resAnzNuller;
	}

	public StringProperty resFsProperty() {
		return resFs;
	}

	public StringProperty resFigFsProperty() {
		return resFigFs;
	}

}
