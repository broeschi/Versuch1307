package converter;
import com.healthmarketscience.jackcess.Row;

import Person.Resultat;

/**
 * Klasse zur Konvertierung der Resultatdaten zwischen DB und Javamodell
 * 
 * @author Ruedi Broger
 */

public class ResultatConverter {
	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row auslesen der Tabellenzeilen
	 * @return persönliche Daten aus der DB 
	 */

	public Resultat dbToModelR(Row row) {
		
		Integer resId = (Integer) row.get("res_id");
		Integer jahr = (Integer) row.get("resJahr");
		Integer resAdrref = (Integer)  row.get("resAdrref");
		Integer resWfRefOp = (Integer)  row.get("resWafRef_OP");
		Integer resWfRefFs = (Integer)  row.get("resWafRef_FS");
		Integer resAlter = (Integer)  row.get("resAlter");
		Integer resLimRef = (Integer)  row.get("resLimref");
		Integer resOp = (Integer)  row.get("resResultat_OP");
		Integer resWhg1 = (Integer)  row.get("resResultat_OP_Whg_1");
		Integer resWhg2 = (Integer)  row.get("resResultat_OP_Whg_2");
		Integer resAnzNuller = (Integer)  row.get("resAnzahlNuller");
		Integer resFs = (Integer)  row.get("resResultat_FS");
		Integer resFigFs = (Integer)  row.get("resFigurentreffer_FS");
		
		
			
		
		Resultat r = new Resultat(resId, jahr, resAdrref, resWfRefOp, resWfRefFs, resAlter, resLimRef, resOp, resWhg1, resWhg2, resAnzNuller, resFs, resFigFs );
		return r;
	}
		
	}
