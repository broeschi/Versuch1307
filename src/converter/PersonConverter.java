package converter;

import java.time.LocalDate;
import java.util.Date;

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

	public Person modelToDbP() {
		String name = new String("adrName");
		String vorname = new String("adrVorname");
		String strasse = new String("adrStrasse");
		// LocalDate gebDat = new LocalDate("adrGebDat");
		String adrNr = new String("adrNr");
		Integer adrPLZ = new Integer("adrPLZ");
		String ort = new String("adrWohnort");
		String ahv = new String("adrAHV");
		String eint = new String("adrMilEinteilung");
		String grad = new String("adrGrad");

		Person p = new Person(null, name, vorname, strasse, null, adrNr, (int) adrPLZ, ort, ahv, eint, grad);
		return p;

	}

}
