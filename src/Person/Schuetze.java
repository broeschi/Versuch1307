package Person;

import java.util.Date;

/** Detailinformationen zur Person*/

public class Schuetze extends Person {
		

	public Schuetze(String adrName, String adrVorname, Date adrGebDat, String adrStrasse, Double adrNr, Double adrPLZ,
			String adrWohnort, String adrGrad, String adrEinteilung, String adrAHV) {
		super(adrName, adrVorname, adrGebDat, adrStrasse, adrNr, adrPLZ, adrWohnort);
		this.adrGrad = adrGrad;
		this.adrEinteilung = adrEinteilung;
		this.adrAHV = adrAHV;
	}

	public String getAdrGrad() {
		return adrGrad;
	}

	public void setAdrGrad(String adrGrad) {
		this.adrGrad = adrGrad;
	}

	public String getAdrEinteilung() {
		return adrEinteilung;
	}

	public void setAdrEinteilung(String adrEinteilung) {
		this.adrEinteilung = adrEinteilung;
	}

	public String getAdrAHV() {
		return adrAHV;
	}

	public void setAdrAHV(String adrAHV) {
		this.adrAHV = adrAHV;
	}

	/** militätischer Grad des Teilnemers*/
	public String adrGrad;

	/** militärische Einteilung des Teilnemers*/
	public String adrEinteilung;
	
	/** AHV bzw. Matrikelnummer des Teilnemers*/
	public String adrAHV;
	
	
	

}
