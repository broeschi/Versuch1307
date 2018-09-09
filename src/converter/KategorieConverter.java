package converter;

import com.healthmarketscience.jackcess.Row;

import Stammdaten.altersKategorie;;

/**
 * Klasse zur Konvertierung der Alterskategorie
 * 
 * 
 * @author Rudolf Broger
 *
 */

public class KategorieConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row
	 *            auslesen der Tabellenzeilen
	 * @return Alterskategorien aus der DB
	 */
	public altersKategorie dbToModelK(Row row) {

		Integer katId = (Integer) row.get("kat_id");
		String katAlterKat = (String) row.get("katAlterskat");
		String katAlterName = (String) row.get("katKat_Name");
		Integer katAlterMin = (Integer) row.get("katAlterMin");
		Integer katAlterMax = (Integer) row.get("katAlterMax");
		Integer sort = (Integer) row.get("katSortierung");

		altersKategorie k = new altersKategorie(katId, katAlterKat, katAlterName, katAlterMin, katAlterMax, sort);
		return k;
	}
	


}
