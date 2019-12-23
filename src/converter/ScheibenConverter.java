package converter;

import com.healthmarketscience.jackcess.*;

import scheibe.Scheibe;

public class ScheibenConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row auslesen der Tabellenzeilen
	 * @return Scheiben aus der DB
	 */
	public Scheibe dbToModelS(Row row) {

		Integer schId = (Integer) row.get("sch_id");
		String schName = (String) row.get("schName");
		String schScheibent = (String) row.get("schSeibent");
		Integer schWert = (Integer) row.get("schWert");

		Scheibe s = new Scheibe(schId, schName, schScheibent, schWert);
		return s;
	}
}
