package converter;

import com.healthmarketscience.jackcess.Row;

import Person.Person;

 

public class PersonConverter {

	public Person dbToModel(Row row) {
		
		Integer adrId = (Integer) row.get("adrId");
		String name = (String) row.get("adrName");
		String vorname = (String)  row.get("adrVorname");
		String strasse = (String)  row.get("adrStrasse");
		String adrNr = (String) row.get("adrNr");
		Short adrPLZ = (Short) row.get("adrPLZ");
		String ort = (String) row.get("adrWohnort");
		
		Person p = new Person(adrId, name, vorname, strasse, adrNr, (int) adrPLZ, ort);
		return p;
	}

}
