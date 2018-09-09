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
		String limAltKat = (String) row.get("limAlterskat");
		Integer limOpErfuellt = (Integer) row.get("limOP-Limite_erfüllt");
		Integer limOpMax0 = (Integer) row.get("limOP-Max_0");
		Integer limOpKarte = (Integer) row.get("limOP_Limite_Karte");
		Integer limFsKarte = (Integer) row.get("limFS_Limite_Karte");
		Integer limFsKranz = (Integer) row.get("limFS_Limite_Kranz");
		Integer limFsFigur = (Integer) row.get("limFS_Figurentreffer");

		limiten l = new limiten(limId, limKatRef, limAltKat, limOpErfuellt, limOpMax0, limOpKarte, limFsKarte,
				limFsKranz, limFsFigur);
		return l;

	}

}
