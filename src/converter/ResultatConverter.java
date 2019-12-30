package converter;

import java.util.HashMap;
import java.util.Map;

import com.healthmarketscience.jackcess.Row;

import person.Person;
import person.Resultat;

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
		Integer resAdrref = (Integer) row.get("resAdrref");
		Integer resWfRefOp = (Integer) row.get("resWafRef_OP");
		Integer resWfRefFs = (Integer) row.get("resWafRef_FS");
		Integer resAlter = (Integer) row.get("resAlter");
		Integer resLimRef = (Integer) row.get("resLimref");
		Integer resOp = (Integer) row.get("resResultat_OP");
		Integer resWhg1 = (Integer) row.get("resResultat_OP_Whg_1");
		Integer resWhg2 = (Integer) row.get("resResultat_OP_Whg_2");
		Integer resAnzNullerOp = (Integer) row.get("resAnzahlNuller");
		Integer resAnzNullerWhg1 = (Integer) row.get("resAnzahlNuller");
		Integer resAnzNullerWhg2 = (Integer) row.get("resAnzahlNuller");
		Integer resFs = (Integer) row.get("resResultat_FS");
		Integer resFigFs = (Integer) row.get("resFigurentreffer_FS");

		Resultat r = new Resultat(resId, jahr, resAdrref, resWfRefOp, resWfRefFs, resAlter, resLimRef, resOp, resWhg1,
				resWhg2, resAnzNullerOp, resAnzNullerWhg1, resAnzNullerWhg2, resFs, resFigFs);
		return r;
	}

	/**
	 * Resultate Daten aus gui in das Datenbankformat konvertieren
	 * 
	 * @author Rudolf Broger
	 * @param resultat Resultat in Access-Format bringen
	 * @return resultat im Access-Format
	 */
	public static Map<String, Object> convertToMap(Resultat resultat, Integer a) {
		Map<String, Object> map = new HashMap<>();
		map.put("res_id", resultat.getRes_id().get());
		map.put("resJahr", util.DateUtil.getYear());
		// map.put("resJahr", resultat.getResJahr());
		map.put("resAdrref", resultat.getResAdrref().get());
		map.put("ResWafRef_OP", resultat.getResWfRefOp().get());
		map.put("resWafRef_FS", resultat.getResWfRefFs().get());
		map.put("resAlter", a);
		map.put("resLimref", resultat.getResLimRef().get());
		map.put("resResultat_OP", resultat.getResOp().get());
		map.put("resResultat_OP_Whg_1", resultat.getResWhg1().get());
		map.put("resResultat_OP_Whg_2", resultat.getResWhg2().get());
		map.put("resAnzahlNuller", resultat.getResAnzNullerOp().get());
		map.put("resAnzahlNuller_Whg_1", resultat.getResAnzNullerOp().get());
		map.put("resAnzahlNuller_Whg_2", resultat.getResAnzNullerOp().get());
		map.put("resResultat_FS", resultat.getResFs().get());
		map.put("resFigurentreffer_FS", resultat.getResFigFs().get());

		return map;
	}

	public static Map<String, Object> convertToMap(Resultat resultat) {
		Map<String, Object> map = new HashMap<>();
		map.put("res_id", resultat.getRes_id().get());
		map.put("resJahr", util.DateUtil.getYear());
		// map.put("resJahr", resultat.getResJahr());
		map.put("resAdrref", resultat.getResAdrref().get());
		map.put("ResWafRef_OP", resultat.getResWfRefOp().get());
		map.put("resWafRef_FS", resultat.getResWfRefFs().get());
		map.put("resAlter", resultat.getResAlter().get());
		map.put("resLimref", resultat.getResLimRef().get());
		map.put("resResultat_OP", resultat.getResOp().get());
		map.put("resResultat_OP_Whg_1", resultat.getResWhg1().get());
		map.put("resResultat_OP_Whg_2", resultat.getResWhg2().get());
		map.put("resAnzahlNuller", resultat.getResAnzNullerOp().get());
		map.put("resAnzahlNuller_Whg_1", resultat.getResAnzNullerOp().get());
		map.put("resAnzahlNuller_Whg_2", resultat.getResAnzNullerOp().get());
		map.put("resResultat_FS", resultat.getResFs().get());
		map.put("resFigurentreffer_FS", resultat.getResFigFs().get());

		return map;
	}

	public static Map<String, Object> convertToMap(Integer adrId) {
		// TODO Auto-generated method stub
		return null;
	}

}
