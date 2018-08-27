package converter;

import com.healthmarketscience.jackcess.Row;

import Person.Person;

 /**
  * Klasse zur Konertierung der Daten zwischen DB und Javamodell
  * 
  * @author Ruedi Broger
  */

public class PersonConverter {
	/**
	 * Daten aus Access transformieren
	 * 
	 * @author Ruedi Broger
	 * @param row auslesen der Tabellenzeilen
	 * @return pers�nliche Daten aus der DB Adressid, Name, Vorname, Strasse, Strassennummer, PLZ, Wohnort, AHV-Nr., Milit�rische Einteilung, Milit�rischer Grad
	 */

	public Person dbToModel(Row row) {
		
		Integer adrId = (Integer) row.get("adrId");
		String name = (String) row.get("adrName");
		String vorname = (String)  row.get("adrVorname");
		String strasse = (String)  row.get("adrStrasse");
		String adrNr = (String) row.get("adrNr");
		Short adrPLZ = (Short) row.get("adrPLZ");
		String ort = (String) row.get("adrWohnort");
		String ahv = (String) row.get("adrAHV");
		String eint = (String) row.get("adrMilEinteilung");
		String grad = (String) row.get("adrGrad");
		
		Person p = new Person(adrId, name, vorname, strasse, adrNr, (int) adrPLZ, ort, ahv, eint, grad);
		return p;
	}

}
