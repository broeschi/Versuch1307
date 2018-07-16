package converter;

import com.healthmarketscience.jackcess.Row;

import Person.Person;
 

public class PersonConverter {

	public Person dbToModel(Row row) {
		// TODO Auto-generated method stub
		Person p = new Person("adrName", null);
		String name = (String) row.get("adrName");
		p.setAdrName(name);
		return p;
	}

}
