package converter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.healthmarketscience.jackcess.Row;

import Person.Person;
import util.DateUtil;

/**
 * Klasse zur Konvertierung der Personendaten zwischen DB und Javamodell
 * 
 * @author Ruedi Broger
 */
public class PersonConverter {
	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row
	 *            auslesen der Tabellenzeilen
	 * @return persönliche Daten aus der DB Adressid, Name, Vorname, Strasse,
	 *         Strassennummer, PLZ, Wohnort, AHV-Nr., Militärische Einteilung,
	 *         Militärischer Grad
	 */
	public Person dbToModelP(Row row) {

		Integer adrId = (Integer) row.get("adrId");
		String name = (String) row.get("adrName");
		String vorname = (String) row.get("adrVorname");
		String strasse = (String) row.get("adrStrasse");
		Date gebDat = row.getDate("adrGebDat");
		String adrNr = (String) row.get("adrNr");
		Short adrPLZ = (Short) row.get("adrPLZ");
		String ort = (String) row.get("adrWohnort");
		String ahv = (String) row.get("adrAHV");
		String eint = (String) row.get("adrMilEinteilung");
		String grad = (String) row.get("adrGrad");

		Person p = new Person(adrId, name, vorname, strasse, DateUtil.convertToLocalDateViaInstant(gebDat), adrNr,
				(int) adrPLZ, ort, ahv, eint, grad);
		return p;
	}
	/**
	 * Persönliche Daten aus GUI in das Datenbankformat konvertieren
	 * 
	 * @author Rudolf Broger
	 * @param person
	 * @return
	 */
	public static Map<String, Object> convertToMap(Person person) {
		Map<String, Object> map = new HashMap<>();
		map.put("adrVorname", person.getAdrVorname());
		map.put("adrStrasse", person.getAdrStrasse());
		map.put("adrNr", person.getAdrNr());
		map.put("adrPLZ", person.getAdrPLZ());
		map.put("adrWohnort", person.getAdrWohnort());
		map.put("adrGebDat", DateUtil.convertToMsEpoch(person.getGebDat()));
		map.put("adrAHV", person.getAdrAHV());
		map.put("adrMil Einteilung", person.getAdrEint());
		map.put("adrGrad", person.getAdrGrad());
		map.put("adrId", person.getAdrId());
		return map;
	}

}
