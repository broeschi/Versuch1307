package stich;

import javafx.beans.property.IntegerProperty;
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
	

	public StichSequenz(Integer sseq_id, Integer sseqReihe, Integer sseqAnzahl, Integer sseqScheibe, Integer sseqRefStch) {
		
		this.sseq_id = sseq_id;
		this.sseqReihe = sseqReihe;
		this.sseqAnzahl = sseqAnzahl;
		this.sseqScheibe = sseqScheibe;
		this.sseqRefStch = sseqRefStch;
		
	}
	
	public Integer sseqReihe() {
		return sseqReihe;
	}

	
	
	public Integer getSseqReihe() {
		return sseqReihe;
	}


	public void setSseqReihe(Integer sseqReihe) {
		this.sseqReihe = sseqReihe;
	}


	public Integer getSseqAnzahl() {
		return sseqAnzahl;
	}


	public void setSseqAnzahl(Integer sseqAnzahl) {
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


	Integer sseq_id;
	Integer sseqReihe;
	Integer sseqAnzahl;
	int sseqScheibe;
	int sseqRefStch;
	
	
	//Konstruktor der Scheibensequenz inklusive der übergeortneten Klasse Scheibe
	

}
