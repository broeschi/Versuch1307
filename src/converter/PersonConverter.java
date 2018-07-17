package converter;

import com.healthmarketscience.jackcess.Row;

import Person.Person;
import javafx.beans.property.StringProperty;
 

public class PersonConverter {

	public Person dbToModel(Row row) {
		// TODO Auto-generated method stub
		Person p = new Person("adrName", "adrVorname");
		String name = (String) row.get("adrName");
		String vorname = (String)  row.get("adrVorname");
		p.setAdrName(name);
		p.setAdrVorname(vorname);
		return p;
	}

}
