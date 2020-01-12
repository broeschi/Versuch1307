package stich;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * Klasse für das Erstellen einer Sequenz eines Stiches. Ein Stich kann unterschiedliche Scheiben (A oder B), 
 * Unterschiedliche Wertungen (4, 5, 10 oder 100) sowie aus Einzel und/oder Schnellfeuer bestehen.
 * Die Klasse erweitert die übergeordnete Klasse der Scheibe
 * 
 * @author Rudolf Broger
 *
 */

public class StichSequenz{
	
	public StichSequenz(Integer sseqRefStch) {
		this.sseqAnzahl = new SimpleIntegerProperty();
	}
	
	public int getSseqReihe() {
		return sseqReihe;
	}


	public void setSseqReihe(int sseqReihe) {
		this.sseqReihe = sseqReihe;
	}


	public SimpleIntegerProperty getSseqAnzahl() {
		return sseqAnzahl;
	}


	public void setSseqAnzahl(SimpleIntegerProperty sseqAnzahl) {
		this.sseqAnzahl = sseqAnzahl;
	}


	public int getSseqScheibe() {
		return sseqScheibe;
	}


	public void setSseqScheibe(int sseqScheibe) {
		this.sseqScheibe = sseqScheibe;
	}


	public int getSseqRefStch() {
		return sseqRefStch;
	}


	public void setSseqRefStch(int sseqRefStch) {
		this.sseqRefStch = sseqRefStch;
	}


	int sseqReihe;
	SimpleIntegerProperty sseqAnzahl;
	int sseqScheibe;
	int sseqRefStch;
	
	
	//Konstruktor der Scheibensequenz inklusive der übergeortneten Klasse Scheibe
	
	public StichSequenz(int stch_id, String stchName, int sseqReihe, SimpleIntegerProperty sseqAnzahl, int sseqScheibe, int sseqRefStch) {
		super();
		this.sseqReihe = sseqReihe;
		this.sseqAnzahl = sseqAnzahl;
		this.sseqScheibe = sseqScheibe;
		this.sseqRefStch = sseqRefStch;
		
	}

}
