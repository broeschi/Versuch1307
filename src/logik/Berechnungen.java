package logik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import datenbank.Datenbank;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import stammdaten.Waffen;
import stammdaten.altersKategorie;
import start.MainApp;

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

	/**
	 * Auf Grund des Alters wird der Person in der Resultattabelle die aktuelle
	 * Alterskategorie zugeordnet
	 * 
	 * @param alter
	 * @return
	 * @throws Exception
	 */
	public static int alterKategorieSetzen(int alter) throws Exception {
		Integer katId = 0;
		Integer a = new Integer(alter);
		ObservableList<altersKategorie> katData = FXCollections.observableArrayList();
		katData = MainApp.getKatData();
		// if (a >= ((altersKategorie) katData).getKatAlterMin().intValue() & a <
		// ((altersKategorie) katData).getKatAlterMax().intValue()) {
		// ((altersKategorie) katData).getKat_id().getValue();
		// katId = stammdaten.altersKategorie.getKat_id().intValue();
		// }
		return katId;

	}

	/**
	 * Es wird berechnet, ob die Person mit der erreichten Resultat die
	 * Schiesspflicht für das aktuelle Jahr erfüllt hat
	 */
	public void schiesspflichtErfuellt() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die Person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) die Anerkennungskarte für das Obligatorische Programm
	 * erhält
	 */
	public void karteOpErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die Person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) die Anerkennungskarte für das Feldschiessen erhält
	 */
	public void karteFsErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die Person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) den Kranz als Auszeichung für das Feldschiessen
	 * erhält
	 */
	public void kranzFsErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
