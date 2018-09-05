package converter;

import com.healthmarketscience.jackcess.*;
import Stammdaten.limiten;

/**
 * 
 * Klasse zur Konvertierung der Limitentabelle aus der DB
 * 
 * @author Rudolf Broger
 *
 */

public class LimitenConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row
	 *            auslesen der Tabellenzeilen
	 * @return Alterskategorien aus der DB
	 */
	public limiten dbToModelL(Row row) {

		Integer limId = (Integer) row.get("lim_id");
		Integer limKatRef = (Integer) row.get("limKatRef");
		String limAltKat = (String) row.get("limAltKat");
		Integer limOpErfuellt = (Integer) row.get("limOpErfuellt");
		Integer limOpMax0 = (Integer) row.get("limOpMax0");
		Integer limOpKarte = (Integer) row.get("limOpKarte");
		Integer limFsKarte = (Integer) row.get("limFsKarte");
		Integer limFsKranz = (Integer) row.get("limFsKranz");
		Integer limFsFigur = (Integer) row.get("limFsFigur");

		limiten l = new limiten(limId, limKatRef, limAltKat, limOpErfuellt, limOpMax0, limOpKarte, limFsKarte,
				limFsKranz, limFsFigur);
		return l;

	}

}
