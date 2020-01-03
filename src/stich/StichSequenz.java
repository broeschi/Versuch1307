package stich;
/**
 * 
 * Klasse für das Erstellen einer Sequenz eines Stiches. Ein Stich kann unterschiedliche Scheiben (A oder B), 
 * Unterschiedliche Wertungen (4, 5, 10 oder 100) sowie aus Einzel und/oder Schnellfeuer bestehen.
 * Die Klasse erweitert die übergeordnete Klasse der Scheibe
 * 
 * @author Rudolf Broger
 *
 */

public class StichSequenz extends Stich{
	int sseqReihe;
	int sseqAnzahl;
	int sseqScheibe;
	int sseqRefStch;
	
	
	//Konstruktor der Scheibensequenz inklusive der übergeortneten Klasse Scheibe
	
	public StichSequenz(int stch_id, String stchName, int sseqReihe, int sseqAnzahl, int sseqScheibe, int sseqRefStch) {
		super(stch_id, stchName);
		this.sseqReihe = sseqReihe;
		this.sseqAnzahl = sseqAnzahl;
		this.sseqScheibe = sseqScheibe;
		this.sseqRefStch = sseqRefStch;
		
	}

}
