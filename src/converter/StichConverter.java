package converter;

import com.healthmarketscience.jackcess.Row;


import stich.Stich;;

/**
 * Klasse zur Konvertierung der Stiche
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
	public Stich dbToModelSt(Row row) {

		Integer katId = (Integer) row.get("kat_id");
		String katAlterKat = (String) row.get("katAlterskat");
		String katAlterName = (String) row.get("katKat_Name");
		Integer katAlterMin = (Integer) row.get("katAlterMin");
		Integer katAlterMax = (Integer) row.get("katAlterMax");
		Integer sort = (Integer) row.get("katSortierung");

		Stich st = new Stich(sort, katAlterName);
		return st;
	}

	}


