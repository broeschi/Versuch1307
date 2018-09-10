package logik;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;

public class Berechnungen {

	/**
	 * aktuelles Alter berechnen die Genauigkeit bezieht sich auf den Jahrgang der
	 * Person
	 * 
	 * @param objectProperty
	 * @return
	 */
	public static int alterSetzen(ObjectProperty<LocalDate> objectProperty) {
		LocalDate GebJahr = objectProperty.getValue();

		int gebJahr = util.DateUtil.getBirthYear(GebJahr);
		int aktJahr = util.DateUtil.getYear();
		int alter = aktJahr - gebJahr;
		return alter;
	}


}
