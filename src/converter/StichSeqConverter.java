package converter;

import com.healthmarketscience.jackcess.Row;


import stich.Stich;
import stich.StichSequenz;;

/**
 * Klasse zur Konvertierung der Stiche
 * 
 * 
 * @author Rudolf Broger
 *
 */

public class StichSeqConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row auslesen der Tabellenzeilen
	 * @return Sequenz zum Zusammenstellen von Stichen aus der DB
	 */
	public StichSequenz dbToModelStq(Row row) {

		Integer sseq_Id = (Integer) row.get("sseq_id");
		Integer sseqAnzahl = (Integer) row.get("sseqAnzahl");
		Integer sseqRefStich = (Integer) row.get("sseqRefStich");
		Integer sseqReihe = (Integer) row.get("sseqReihe");
		Integer sseqScheibe = (Integer) row.get("sseqScheibe");

		StichSequenz stq = new StichSequenz(sseq_Id, sseqReihe, sseqAnzahl, sseqScheibe,  sseqRefStich);
		return stq;
	}

	}


