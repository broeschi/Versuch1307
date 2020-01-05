package converter;

import com.healthmarketscience.jackcess.Row;

import stammdaten.AltersKategorie;
import stich.Stich;;

/**
 * Klasse zur Konvertierung der Alterskategorie
 * 
 * 
 * @author Rudolf Broger
 *
 */

public class StichConverter {

	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row auslesen der Tabellenzeilen
	 * @return Stiche aus der DB
	 */
	public AltersKategorie dbToModelK(Row row) {

		Integer katId = (Integer) row.get("kat_id");
		String katAlterKat = (String) row.get("katAlterskat");
		String katAlterName = (String) row.get("katKat_Name");
		Integer katAlterMin = (Integer) row.get("katAlterMin");
		Integer katAlterMax = (Integer) row.get("katAlterMax");
		Integer sort = (Integer) row.get("katSortierung");

		AltersKategorie k = new AltersKategorie(katId, katAlterKat, katAlterName, katAlterMin, katAlterMax, sort);
		return k;
	}

	public Stich dbToModelSt(Row row) {
		// TODO Automatisch generierter Methodenstub
		return null;
	}

}
