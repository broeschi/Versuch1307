package converter;

import com.healthmarketscience.jackcess.Row;

import Person.Resultat;
import Stammdaten.waffen;

/**
 * Klasse zur Konvertierung der Waffenkategorieren zwischen DB und Javamodell
 * 
 * @author Ruedi Broger
 */
public class WaffenConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row
	 *            auslesen der Tabellenzeilen
	 * @return Liste von Waffen aus der DB
	 */
	public waffen dbToModelW(Row row) {

		Integer waf_id = (Integer) row.get("waf_id");
		String wafName = (String) row.get("wafWaffe");
		String wafAbk = (String) row.get("wafWaffe_Abk");
		String wafKat = (String) row.get("wafWaffen_Kat");

		waffen w = new waffen(waf_id, wafName, wafAbk, wafKat);
		return w;

	}
}