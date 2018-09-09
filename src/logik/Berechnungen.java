package logik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import Stammdaten.Waffen;
import Stammdaten.altersKategorie;
import Start.MainApp;
import datenbank.Datenbank;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Berechnungen {

	// aktuelles Alter berechnen
	// die Genauigkeit bezieht sich auf den Jahrgang der Person
	public static int alterSetzen(ObjectProperty<LocalDate> objectProperty) {
		LocalDate GebJahr = objectProperty.getValue();
		
		int gebJahr = util.DateUtil.getBirthYear(GebJahr);
		int aktJahr = util.DateUtil.getYear();
		int alter = aktJahr - gebJahr;
		return alter;
	}

	public static int alterKategorieSetzen(int alter) throws Exception {
		Integer katId = 0;
		Integer a = new Integer (alter);
		ObservableList<altersKategorie> katData = FXCollections.observableArrayList();
		katData = MainApp.getKatData();
		if (a >= ((altersKategorie) katData).getKatAlterMin().intValue() & a < ((altersKategorie) katData).getKatAlterMax().intValue()) {
			((altersKategorie) katData).getKat_id().getValue();
			//katId = Stammdaten.altersKategorie.getKat_id().intValue();
		}
		return katId;

	}

	public void schiesspflichtErfuellt() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void karteOpErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void karteFsErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
