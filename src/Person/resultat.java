package Person;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * Klasse für Resultate
 * @author Ruedi Broger
 *
 */
public class resultat {
	private final IntegerProperty res_id;
	private final IntegerProperty resJahr;
	private final IntegerProperty resAdrref;
	private final IntegerProperty resWfRefOp;
	private final IntegerProperty resWfRefFs;
	private final IntegerProperty resAlter;
	private final IntegerProperty resLimRef;
	private final IntegerProperty resOp;
	private final IntegerProperty resWhg1;
	private final IntegerProperty resWhg2;
	private final IntegerProperty resAnzNuller;
	private final IntegerProperty resFs;
	private final IntegerProperty resFigFs;
	
	
	
	
	public resultat(int res_id, int resJahr, int resAdrref, int resWfRefOp, int resWfRefFs, int resAlter, int resLimRef, int resOp, int resWhg1, int resWhg2, int resAnzNuller, int resFs, int resFigFs) {
		this.res_id = new SimpleIntegerProperty(res_id);
		this.resJahr = new SimpleIntegerProperty(resJahr);
		this.resAdrref = new SimpleIntegerProperty(resAdrref);
		this.resWfRefOp = new SimpleIntegerProperty(resWfRefOp);
		this.resWfRefFs = new SimpleIntegerProperty(resWfRefFs);
		this.resAlter = new SimpleIntegerProperty(resAlter);
		this.resLimRef = new SimpleIntegerProperty(resLimRef);
		this.resOp = new SimpleIntegerProperty(resOp);
		this.resWhg1 = new SimpleIntegerProperty(resWhg1);
		this.resWhg2 = new SimpleIntegerProperty(resWhg2);
		this.resAnzNuller = new SimpleIntegerProperty(resAnzNuller);
		this.resFs = new SimpleIntegerProperty(resFs);
		this.resFigFs = new SimpleIntegerProperty(resFigFs);
		
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



	public IntegerProperty getResWfRefOp() {
		return resWfRefOp;
	}



	public IntegerProperty getResWfRefFs() {
		return resWfRefFs;
	}



	public IntegerProperty getResAlter() {
		return resAlter;
	}



	public IntegerProperty getResLimRef() {
		return resLimRef;
	}



	public IntegerProperty getResOp() {
		return resOp;
	}



	public IntegerProperty getResWhg1() {
		return resWhg1;
	}



	public IntegerProperty getResWhg2() {
		return resWhg2;
	}



	public IntegerProperty getResAnzNuller() {
		return resAnzNuller;
	}



	public IntegerProperty getResFs() {
		return resFs;
	}



	public IntegerProperty getResFigFs() {
		return resFigFs;
	}




	

}
